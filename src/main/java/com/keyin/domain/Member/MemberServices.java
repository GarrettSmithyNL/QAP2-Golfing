package com.keyin.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServices {
  @Autowired
  private MemberRepository memberRepository;

  public Member createMember(Member newMember) {
    return memberRepository.save(newMember);
  }

  public Member findMemberById(long id) {
    Optional<Member> optionalMember = memberRepository.findById(id);
    return optionalMember.orElse(null);
  }
}
