package com.groom.domain.board.exception;

import com.groom.global.advice.ErrorCode;
import com.groom.global.advice.exception.BusinessException;

public class NotAllowedControlBoardException extends BusinessException {

    public NotAllowedControlBoardException() {
        super(ErrorCode.NOT_ALLOWED_CONTROL_BOARD_ERROR);
    }
}