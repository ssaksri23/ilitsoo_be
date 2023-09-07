package com.groom.domain.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessListResponse {
    private Long businessId;
    private String businessName;
    private String phoneNumber;
    private String businessType;
    private String recruitState;
    private Double latitude;
    private Double longitude;
    private String address;
    private Long totalWorkDate;
}