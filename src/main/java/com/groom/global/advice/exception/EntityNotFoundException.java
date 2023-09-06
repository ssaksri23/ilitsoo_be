package com.groom.global.advice.exception;

import com.groom.global.advice.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException() {
        super(ErrorCode.ENTITY_NOT_FOUND_ERROR);
    }
}