package com.groom.domain.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MyBusinessListResponse {
    private String businessName;
    private String recruitState;
     private String address;
}