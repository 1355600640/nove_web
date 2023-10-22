package com.qingfeng.henthouse.common;

import com.qingfeng.henthouse.enmus.ControlStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseObject<T> implements Serializable {

    private Integer status;
    private String message;
    private T data;

    public ApiResponseObject(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    // 接口运行成功
    public static <T> ApiResponseObject<T> success(T data){
        ApiResponseObject apiResponseObject = ApiResponseObject.builder()
                .status(ControlStatus.SUSSES.getErrorCode())
                .message(ControlStatus.SUSSES.getErrorMsg())
                .data(data).build();
        return apiResponseObject;
    }

    // 接口参数错误
    public static <T> ApiResponseObject<T> errorParam(T data){
        ApiResponseObject apiResponseObject = ApiResponseObject.builder()
                .status(ControlStatus.ERROR_DATA_EMPEY.getErrorCode())
                .message(ControlStatus.ERROR_DATA_EMPEY.getErrorMsg())
                .data(data).build();
        return apiResponseObject;
    }

    // 解构运行出错
    public static <T> ApiResponseObject<T> error(T data){
        ApiResponseObject apiResponseObject = ApiResponseObject.builder()
                .status(ControlStatus.FAIL.getErrorCode())
                .message(ControlStatus.FAIL.getErrorMsg())
                .data(data).build();
        return apiResponseObject;
    }
}
