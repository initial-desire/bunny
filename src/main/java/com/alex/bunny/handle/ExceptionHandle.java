package com.alex.bunny.handle;

import com.alex.bunny.domain.Result;
import com.alex.bunny.exception.GirlException;
import com.alex.bunny.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException){
            GirlException exception = (GirlException) e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        } else {
            logger.info("系统错误{}", e);
            return ResultUtil.error(-1,"未知错误");
        }
    }

}
