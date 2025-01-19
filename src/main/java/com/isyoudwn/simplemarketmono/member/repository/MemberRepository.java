package com.isyoudwn.simplemarketmono.member.repository;

import com.isyoudwn.simplemarketmono.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
