package com.groom.domain.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusinessDetailResponse {
    private Long businessId;
    private String businessName;
    private String businessNumber;
    private String phoneNumber;
    private String workStartDate;
    private String workFinishDate;
    private String workStartTime;
    private String workFinishTime;
    private String businessType;
    private Integer salary;
    private String businessDetail;
    private String address;
    private Long latitude;
    private Long longitude;
    private String recruitState;
}