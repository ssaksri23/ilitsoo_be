package com.groom.domain.member.service;

import com.groom.domain.auth.dto.request.LoginRequest;
import com.groom.domain.auth.dto.response.LoginResponse;
import com.groom.domain.auth.jwt.JwtProvider;
import com.groom.domain.member.dto.request.MemberRegisterRequest;
import com.groom.domain.member.dto.response.MemberRegisterResponse;
import com.groom.domain.member.entity.Member;
import com.groom.domain.member.exception.EmailDuplicateException;
import com.groom.domain.member.exception.LoginFailedException;
import com.groom.domain.member.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.groom.domain.auth.util.PasswordEncryptor.hashPassword;
import static com.groom.domain.auth.util.PasswordEncryptor.verifyPassword;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MemberService {
    MemberRepository memberRepository;
    JwtProvider jwtProvider;

    /*
    * 로그인
    * */
    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail());

        if (member != null
                && verifyPassword(member.getPassword(), hashPassword(request.getPassword()))) {
            return new LoginResponse(jwtProvider.createToken(member));
        }
        throw new LoginFailedException();
    }

    /*
     *  회원 등록
     * */
    @Transactional
    public MemberRegisterResponse registerMember(MemberRegisterRequest request) {
        // email duplicate check
        if(memberRepository.findByEmail(request.getEmail()) != null) {
            throw new EmailDuplicateException();
        }
        else {
            Member mentor = Member.builder()
                    .email(request.getEmail())
                    .password(hashPassword(request.getPassword()))
                    .build();

            memberRepository.save(mentor);
            return new MemberRegisterResponse();
        }
    }
}