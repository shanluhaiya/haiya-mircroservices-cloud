package com.haiya.log.config;

import com.haiya.common.exception.DefaultExceptionAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 统一异常处理
 *
 * @author qiaoguoqiang
 */
@ControllerAdvice
public class ExceptionAdvice extends DefaultExceptionAdvice {
}
