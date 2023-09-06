package com.groom.domain.auth.exception;

import com.groom.global.advice.ErrorCode;
import com.groom.global.advice.exception.BusinessException;

public class JwtAuthorizationException extends BusinessException {

    public JwtAuthorizationException() {
        super(ErrorCode.JWT_AUTHORIZATION_ERROR);
    }
}