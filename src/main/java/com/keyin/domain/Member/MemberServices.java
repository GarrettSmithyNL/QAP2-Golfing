package com.keyin.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServices {
  private final MemberRepository memberRepository;

  @Autowired
  public MemberServices(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member createMember(Member newMember) {
    Member memberInDb = findMemberByNameAndEmail(newMember);
    if(memberInDb != null) {
      newMember = memberInDb;
    } else {
      newMember.setDurationOfMemberInDays(calcMembershipDuration(newMember.getStartOfMember()));
    }
    return memberRepository.save(newMember);
  }

  public List<Member> createMembers(List<Member> newMembers) {
    List<Member> updatedMembers = new ArrayList<>();
    for(Member newMember : newMembers) {
      Member memberInDb = findMemberByNameAndEmail(newMember);
      if (memberInDb != null) {
        updatedMembers.add(updateMember(memberInDb));
      } else {
        updatedMembers.add(createMember(newMember));
      }
    }
    return (List<Member>) memberRepository.saveAll(updatedMembers);
  }

  public Member updateMember(Member memberToUpdate) {
    Member memberInDb = findMemberByNameAndEmail(memberToUpdate);
    if(memberToUpdate.getAddress() != null) {
      memberInDb.setAddress(memberToUpdate.getAddress());
    }
    if(memberToUpdate.getPhoneNumber() != null) {
      memberInDb.setPhoneNumber(memberToUpdate.getPhoneNumber());
    }
    return memberInDb;
  }

  public Member findMemberById(long id) {
    Optional<Member> optionalMember = memberRepository.findById(id);
    return optionalMember.orElse(null);
  }

  public Member findMemberByNameAndEmail(Member member) {
    return memberRepository.findByNameAndEmail(member.getName(), member.getEmail());
  }

  private long calcMembershipDuration(LocalDate startDate) {
    LocalDate today = LocalDate.now();
    return ChronoUnit.DAYS.between(startDate, today);
  }
}
