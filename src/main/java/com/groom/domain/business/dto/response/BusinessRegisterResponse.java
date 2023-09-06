package com.groom.domain.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessRegisterResponse {
    private final String message = "사업자 공고 등록을 성공적으로 완료했습니다.";
}