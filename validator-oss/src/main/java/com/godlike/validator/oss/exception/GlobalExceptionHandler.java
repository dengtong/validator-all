package com.godlike.validator.oss.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseBody MethodArgumentNotValidHandler(BindException exception) {
        printLog(exception);
        StringBuffer errorMessage = new StringBuffer();
        StringBuffer errorCode = new StringBuffer();
        if (exception.getBindingResult().hasErrors()) {
            exception.getBindingResult().getAllErrors().forEach(error -> {
                String errorBody = error.getDefaultMessage();
                int errorCodeStartIndex = errorBody.lastIndexOf("@");
                if (errorCodeStartIndex > 0) {
                    errorMessage.append(errorBody, 0, errorCodeStartIndex);
                    if (errorCodeStartIndex != errorBody.length() - 1) {
                        errorCode.append(errorBody, errorCodeStartIndex + 1, errorBody.length());
                    }
                } else {
                    errorMessage.append(errorBody);
                }
            });
        }
        return new ErrorResponseBody(errorMessage.toString(), errorCode.toString());
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
        return new ErrorResponseBody(exception.getMessage(), exception.getCode());
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
        return new ErrorResponseBody(exception.getMessage(), exception.getCode());
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
        return new ErrorResponseBody(exception.getMessage(), "404000");
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
        return new ErrorResponseBody(exception.getMessage(), "405000");
    }

    /**
     * 服务器内部错误(自定义错误码，可用580000以下的)
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseBody exceptionHandler(InternalServerErrorException exception) {
        printLog(exception);
        return new ErrorResponseBody(exception.getMessage(), exception.getCode());
    }

    /**
     * 服务器内部错误（未知的运行时错误）
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseBody exceptionHandler(RuntimeException exception) {
        printLog(exception);
        return new ErrorResponseBody(exception.getMessage(), "580000");
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseBody defaultErrorHandler(Exception exception) {
        printLog(exception);
        return new ErrorResponseBody(exception.getMessage(), "590000");
    }

    private void printLog(Throwable throwable) {
        logger.error("{}", throwable);
    }
}
