package com.scut.seckill.common;

import com.scut.seckill.exception.SecKillException;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private Logger log;

    @ExceptionHandler(value = SecKillException.class)
    @ResponseBody
    public Message handleSecKillException(SecKillException secKillException){
        System.out.println(secKillException.getSecKillEnum().getMessage());
        return new Message(secKillException.getSecKillEnum());
    }
}
