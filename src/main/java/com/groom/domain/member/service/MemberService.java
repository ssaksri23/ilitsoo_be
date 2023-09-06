package com.groom.domain.member.service;

import com.groom.domain.member.dto.request.LoginRequest;
import com.groom.domain.member.dto.response.LoginResponse;
import com.groom.domain.member.entity.Member;
import com.groom.domain.member.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MemberService {
    MemberRepository memberRepository;

    /*
    * 로그인 및 회원가입
    * */
     public LoginResponse login(LoginRequest request) {
         // 회원가입이 완료되었는지 확인하기
         Member member = memberRepository.findByEmail(request.getEmail());
         if(member == null) {
             member = Member.builder()
                     .email(request.getEmail())
                     .username(request.getUsername())
                     .userType("구직자")
                     .build();
             memberRepository.save(member);
         }
         return new LoginResponse(member.getId(), member.getUserType());
    }
}