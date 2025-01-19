package com.isyoudwn.simplemarketmono.member.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String encryptedPassword;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(length = 30)
    private String phoneNumber;

    public static Member create(String nickname, String email, String password, String phoneNumber) {
        return builder()
                .email(email)
                .encryptedPassword(password)
                .phoneNumber(phoneNumber)
                .nickname(nickname)
                .build();
    }
}
