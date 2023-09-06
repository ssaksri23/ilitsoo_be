package com.groom.domain.business.service;

import com.groom.domain.business.dto.request.BusinessRegisterRequest;
import com.groom.domain.business.dto.response.BusinessRegisterResponse;
import com.groom.domain.business.entity.Business;
import com.groom.domain.business.repository.BusinessRepository;
import com.groom.domain.member.entity.Member;
import com.groom.domain.member.repository.MemberRepository;
import com.groom.global.advice.exception.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessService {
    BusinessRepository businessRepository;
    MemberRepository memberRepository;

    /*
    * 사업장 정보 등록
    * */
     public BusinessRegisterResponse registerBusiness(BusinessRegisterRequest request) {
         Member member = memberRepository.findById(request.getUserId()).orElseThrow(EntityNotFoundException::new);

         businessRepository.save(
                 Business.builder()
                         .member(member)
                         .businessName(request.getBusinessName())
                         .businessNumber(request.getBusinessNumber())
                         .phoneNumber(request.getPhoneNumber())
                         .workStartDate(request.getWorkStartDate())
                         .workFinishDate(request.getWorkFinishDate())
                         .workStartTime(request.getWorkStartTime())
                         .workFinishTime(request.getWorkFinishTime())
                         .businessDetail(request.getBusinessDetail())
                         .businessType(request.getBusinessType())
                         .salary(request.getSalary())
                         .address(request.getAddress())
                         .latitude(request.getLatitude())
                         .longitude(request.getLongitude())
                         .recruitState("모집중")
                         .build()
         );
         return new BusinessRegisterResponse();
    }
}