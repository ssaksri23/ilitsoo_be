package com.groom.domain.business.controller;

import com.groom.domain.business.dto.request.BusinessRegisterRequest;
import com.groom.domain.business.dto.response.*;
import com.groom.domain.business.service.BusinessService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/business")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessController {
    BusinessService businessService;

    /*
    * 사업 등록
    * */
    @PostMapping
    private ResponseEntity<BusinessRegisterResponse> registerBusiness(@Valid @RequestBody BusinessRegisterRequest request) {
        return ResponseEntity.ok().body(businessService.registerBusiness(request));
    }

    /*
    * 사업 목록 조회
    * */
    @GetMapping
    private ResponseEntity<List<BusinessListResponse>> findAllBusiness() {
        return ResponseEntity.ok().body(businessService.findAllBusiness());
    }

    /*
    * 사업장 상세 조회
    * */
    @GetMapping("/{businessId}")
    private ResponseEntity<BusinessDetailResponse> findBusinessById(@PathVariable("businessId") Long businessId) {
        return ResponseEntity.ok().body(businessService.findBusinessById(businessId));
    }

    /*
    * 회원별 사업장 목록 조회
    * */
    @GetMapping("/member/{memberId}")
    private ResponseEntity<List<MyBusinessListResponse>> findBusinessByMemberId(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok().body(businessService.findBusinessByMemberId(memberId));
    }

    /*
    * 모집 상태 변경
    * */
    @PutMapping("/{businessId}")
    private ResponseEntity<BusinessUpdateResponse> updateBusiness(@PathVariable("businessId") Long businessId) {
        return ResponseEntity.ok().body(businessService.updateBusiness(businessId));
    }
}