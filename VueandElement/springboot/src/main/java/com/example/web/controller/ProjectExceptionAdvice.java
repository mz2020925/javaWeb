package com.example.web.controller;

import com.example.exception.BusinessException;
import com.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)  // 说明这个方法处理哪种异常
    public Result doSystemException(SystemException e){
        // 记录日志

        // 发送消息给运维

        // 发送邮件给开发人员，邮件需要包含传过来的e

        // 给前端一个信息，用于展示
        return new Result(e.getCode(), null, e.getMessage());
    }

    public Result doBusinessException(BusinessException e){
        // 给前端一个信息，用于展示，业务异常就这样处理，不想系统异常需要那么多工作
        return new Result(e.getCode(), null, e.getMessage());

    }

    @ExceptionHandler(Exception.class)  // 把剩余的所有的异常拦截过来
    public Result doException(Exception e){
        // 记录日志

        // 发送消息给运维

        // 发送邮件给开发人员，邮件需要包含传过来的e

        // 给前端一个信息，用于展示
        // System.out.println(e.toString());
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "系统繁忙，请稍后再试");
    }
}
