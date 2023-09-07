package com.groom.domain.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessUpdateResponse {
    private final String message = "사업장 모집 상태를 성공적으로 수정했습니다.";
}