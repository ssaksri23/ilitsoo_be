package com.groom.domain.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessListResponse {
    private String businessName;
    private String phoneNumber;
    private String businessType;
    private Long latitude;
    private Long longitude;
    private String address;
    private Long totalWorkDate;
}