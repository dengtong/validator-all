package com.godlike.validator.oss.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 参数校验不通过
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseBody MethodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        printLog(exception);
        StringBuffer errorSB = new StringBuffer();
        if (exception.getBindingResult().hasErrors()) {
            exception.getBindingResult().getAllErrors().forEach(error -> errorSB.append(error.getDefaultMessage()));
        }
        return new ErrorResponseBody(errorSB.toString());
    }


    /**
     * 没有通过身份验证
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseBody unauthorizedExceptionHandler(UnauthorizedException exception) {
        printLog(exception);
        return new ErrorResponseBody("无效用户");
    }

    /**
     * 不具有访问资源所需的权限(也就是没有请求的url的权限)
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponseBody forbiddenExceptionHandler(ForbiddenException exception) {
        printLog(exception);
        return new ErrorResponseBody("不具有访问资源所需的权限");
    }

    /**
     * 未找到对应的资源
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseBody noHandlerFoundExceptionHandler(NoHandlerFoundException exception) {
        printLog(exception);
        return new ErrorResponseBody("路径错误");
    }

    /**
     * 所用的 HTTP 方法不在权限之内(用户校验通过，url有权限，http方法没有权限)
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponseBody methodNotAllowedExceptionHandler(MethodNotAllowedException exception) {
        printLog(exception);
        return new ErrorResponseBody("不具有http方法权限");
    }

    /**
     * 服务器内部错误
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseBody exceptionHandler(RuntimeException exception) {
        printLog(exception);
        return new ErrorResponseBody("服务器（代码）发生错误");
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorResponseBody defaultErrorHandler(Exception exception) {
        printLog(exception);
        return new ErrorResponseBody("未知错误");
    }

    private void printLog(Throwable throwable) {
        logger.error("{}", throwable);
    }
}
