package com.groom.domain.member.exception;

import com.groom.global.advice.ErrorCode;
import com.groom.global.advice.exception.BusinessException;

public class LoginFailedException extends BusinessException {

    public LoginFailedException() {
        super(ErrorCode.LOGIN_FAILED_ERROR);
    }
}