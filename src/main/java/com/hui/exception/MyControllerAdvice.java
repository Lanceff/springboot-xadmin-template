package com.hui.exception;

import com.hui.converter.DateConverter;
import com.hui.response.ResponseErrEntity;
import com.hui.status.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1、通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 * 2、注解了@Controller的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
 * 3、@ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。
 * 4、@ExceptionHandler：用于全局处理控制器里的异常。
 * 5、@InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。
 * 6、@ModelAttribute：本来作用是绑定键值对到Model中，此处让全局的@RequestMapping都能获得在此处设置的键值对
 */
@ControllerAdvice
public class MyControllerAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception ex) {
        ResponseErrEntity res = new ResponseErrEntity(StatusCode.Fail);
        res.setMsg(ex.getMessage());
        logger.debug(">>>>>ERROR:" + ex.getMessage());
        return res;
    }


    /**
     * 可将http请求参数中的时间自动转换成Date类型。
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        GenericConversionService genericConversionService = (GenericConversionService) binder.getConversionService();
        if (genericConversionService != null) {
            genericConversionService.addConverter(new DateConverter());
        }
    }


}
