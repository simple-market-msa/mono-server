package com.isyoudwn.simplemarketmono.member.service;

import com.isyoudwn.simplemarketmono.common.response.ResponseMessage;
import com.isyoudwn.simplemarketmono.member.dto.MemberRequestDto.CreateMemberDto;
import com.isyoudwn.simplemarketmono.member.model.Member;
import com.isyoudwn.simplemarketmono.member.exception.MemberException;
import com.isyoudwn.simplemarketmono.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() ->
                new MemberException(ResponseMessage.MEMBER_NOT_FOUND)
        );
    }

    @Transactional
    public Member saveMember(CreateMemberDto createMemberDto) {
        Member member = Member.create(
                createMemberDto.nickname(),
                createMemberDto.email(),
                createMemberDto.password(),
                createMemberDto.phoneNumber()
        );
        return memberRepository.save(member);
    }
}
