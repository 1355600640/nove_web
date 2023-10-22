package com.qingfeng.henthouse.control;

import com.baomidou.kaptcha.Kaptcha;
import com.qingfeng.henthouse.Dto.UserRegisterDto;
import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.common.LoginUser;
import com.qingfeng.henthouse.enmus.CodeSource;
import com.qingfeng.henthouse.enmus.ControlStatus;
import com.qingfeng.henthouse.pojo.SysUser;
import com.qingfeng.henthouse.pojo.UserInfo;
import com.qingfeng.henthouse.service.SysUserService;
import com.qingfeng.henthouse.utils.RedisCache;
import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 用户接口
@RestController
@RequestMapping("/user")
@Api(("用户接口"))
public class SysUserControl {

    @Autowired
    private Kaptcha kaptcha;

    @Autowired
    private SysUserService userService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

//    private static final Logger logger = Logger.getLogger(SysUserControl.class);

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public ApiResponseObject<Map<String, Object>> login( @RequestBody SysUser user){
        String token = userService.userLogin(user);
        Map<String, Object> map = new HashMap<>();
        map.put("Token",token);
        return new ApiResponseObject(ControlStatus.SUSSES.getErrorCode(), ControlStatus.SUSSES.getErrorMsg(),map);
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public ApiResponseObject<String> register(HttpServletRequest request, @RequestBody UserRegisterDto  user){
        String ip = "";
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        Boolean b = userService.userRegister(user, ip);
        if(!b){
            return new ApiResponseObject<>(ControlStatus.FAIL.getErrorCode(),ControlStatus.FAIL.getErrorMsg(),"注册失败");
        }
        return new ApiResponseObject<>(ControlStatus.SUSSES.getErrorCode(), ControlStatus.SUSSES.getErrorMsg(),"注册成功");
    }

    @GetMapping("/verificationCode")
    @ApiOperation(value = "获取用户登录验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型 random:随机数字字母 png:png gif:gif cn:中文 cngif:中文gif arithmeti:算术", required = false, paramType = "query"),
            @ApiImplicitParam(name = "count", value = "请求次数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "source",value = "请求来源", required = true, paramType = "query" )
    })
    public ApiResponseObject code(HttpServletRequest request, HttpServletResponse response,@RequestParam(defaultValue = "arithmeti", required = false) String type,int count,@RequestParam(defaultValue = "1") int source) throws IOException {
        String ip = "";
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        Map<String, Object> cacheMap=null;
        try{
           cacheMap = redisCache.getCacheObject(("code:" + ip));
        }catch (Exception e){
//            logger.info("ip: " + ip + "没有5秒内获取过验证码");
        }
        if(count>=1&& (cacheMap!=null)){
            long time = 5;
            if(!Objects.isNull(cacheMap)){
                long lastTime =  LocalDateTime.parse((String)cacheMap.get("time")).toEpochSecond(ZoneOffset.ofHours(8));
                long epochSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
                time = 5- (epochSecond- lastTime);
            }
            System.out.printf("ip: " + ip+"\t请求验证码频繁");
            if(time>0) return new ApiResponseObject(ControlStatus.FAIL.getErrorCode(),ControlStatus.FAIL.getErrorMsg(),"请求验证码频繁,请"+time+"秒后重试");
        }
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        Captcha captcha = null;
        switch (type) {
            case "random":
                kaptcha.render();
            case "png":
                captcha = new SpecCaptcha(130, 48);
                break;
            case "gif":
                // gif类型
                captcha = new GifCaptcha(130, 48);
                break;
            case "cn":
                // 中文类型
                captcha = new ChineseCaptcha(130, 48, 5, new Font("楷体", Font.PLAIN, 28));
                break;
            case "cngif":
                // 中文gif类型
                captcha = new ChineseGifCaptcha(130, 48, 5, new Font("楷体", Font.PLAIN, 28));
                break;
            case "arithmeti":
                // 算术类型
                ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(130, 48);
                arithmeticCaptcha.setLen(3);  // 几位数运算，默认是两位
                arithmeticCaptcha.getArithmeticString();  // 获取运算的公式：3+2=?
                arithmeticCaptcha.text();  // 获取运算的结果：5
                captcha = arithmeticCaptcha;
                break;
            default:
                new SpecCaptcha(130, 48);
                break;
        }
//        log.info("验证码:{}", captcha.text());
        // 设置字体
        //captcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        if(!type.equals("random")) captcha.setCharType(Captcha.TYPE_DEFAULT);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",captcha.text().toLowerCase());
        map.put("time", LocalDateTime.now());
        String codeName = "";
        switch (source) {
            case 1: codeName = CodeSource.UserCode.getMsg();break;
        }
        //缓存验证码
        redisCache.setCacheObject(codeName +":" +ip,map);
        // 输出图片流
        String param = captcha.toBase64();
        return new ApiResponseObject(ControlStatus.SUSSES.getErrorCode(),ControlStatus.SUSSES.getErrorMsg(),param);
    }

    @GetMapping("/getUserSession")
    @ApiOperation(value = "获取用户信息")
    public ApiResponseObject<UserInfo> userSession(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser =  (LoginUser) authentication.getPrincipal();
        return ApiResponseObject.success(loginUser.getUser());
    }

    // TODO 持久登录

    // TODO 登出
    @PostMapping("/logout")
    @ApiOperation(value = "用户登出")
    public ApiResponseObject logout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser =  (LoginUser) authentication.getPrincipal();
        redisCache.deleteObject("User-novel:"+loginUser.getUser().getId());
        return ApiResponseObject.success("用户登出成功");
    }

}
