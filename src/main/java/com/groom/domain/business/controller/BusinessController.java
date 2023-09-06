package com.groom.domain.business.controller;

import com.groom.domain.business.dto.request.BusinessRegisterRequest;
import com.groom.domain.business.dto.response.BusinessRegisterResponse;
import com.groom.domain.business.service.BusinessService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/business")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessController {
    BusinessService businessService;

    /*
    * 로그인
    * */
    @PostMapping
    private ResponseEntity<BusinessRegisterResponse> registerBusiness(@Valid @RequestBody BusinessRegisterRequest request) {
        return ResponseEntity.ok().body(businessService.registerBusiness(request));
    }
}