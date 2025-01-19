package com.isyoudwn.simplemarketmono.member.controller;

import static com.isyoudwn.simplemarketmono.common.response.ResponseMessage.CREATE_MEMBER_SUCCESS;

import com.isyoudwn.simplemarketmono.common.response.Response;
import com.isyoudwn.simplemarketmono.member.dto.MemberRequestDto.CreateMemberDto;
import com.isyoudwn.simplemarketmono.member.model.Member;
import com.isyoudwn.simplemarketmono.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<Response<String>> createMember(@RequestBody CreateMemberDto createMemberDto) {

        Member member = memberService.saveMember(createMemberDto);

        return ResponseEntity
                .ok()
                .body(Response.success(
                        CREATE_MEMBER_SUCCESS.getCode(),
                        CREATE_MEMBER_SUCCESS.getMessage()
                ));
    }
}
