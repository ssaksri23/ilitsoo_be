package com.groom.domain.member.exception;

import com.groom.global.advice.ErrorCode;
import com.groom.global.advice.exception.BusinessException;
public class EmailDuplicateException extends BusinessException {

    public EmailDuplicateException() {
        super(ErrorCode.EMAIL_DUPLICATION_ERROR);
    }
}