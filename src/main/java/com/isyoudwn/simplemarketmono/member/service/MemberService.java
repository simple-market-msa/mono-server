package com.isyoudwn.simplemarketmono.member.service;

import com.isyoudwn.simplemarketmono.common.response.ResponseMessage;
import com.isyoudwn.simplemarketmono.member.model.Member;
import com.isyoudwn.simplemarketmono.member.exception.MemberException;
import com.isyoudwn.simplemarketmono.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() ->
                new MemberException(ResponseMessage.MEMBER_NOT_FOUND)
        );
    }
}
