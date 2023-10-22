package com.qingfeng.henthouse.handle;

import com.qingfeng.henthouse.common.ApiResponseObject;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 访问不存在URL
@Controller
public class NoFoundController extends AbstractErrorController {
    public NoFoundController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(("${server.error.path:/error}"))
    public ResponseEntity<ApiResponseObject> notFoundURL(HttpServletRequest request, HttpServletResponse response){
        ApiResponseObject apiResponseObject = new ApiResponseObject();
        apiResponseObject.setStatus(HttpStatus.NOT_FOUND.value());
        apiResponseObject.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        return  new ResponseEntity<ApiResponseObject>(apiResponseObject,HttpStatus.OK);
    }

}
