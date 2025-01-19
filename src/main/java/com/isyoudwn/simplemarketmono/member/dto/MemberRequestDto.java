package com.isyoudwn.simplemarketmono.member.dto;

public class MemberRequestDto {

    public record CreateMemberDto(
        String nickname,
        String email,
        String phoneNumber,
        String password
    ) {
    }

    ;
}
