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
    Member memberInDb = findMember(newMember);
    if(memberInDb != null) {
      updateMember(newMember, memberInDb);
      newMember = memberInDb;
    } else {
      newMember.setDurationOfMemberInDays(calcMembershipDuration(newMember.getStartOfMember()));
    }
    return memberRepository.save(newMember);
  }

  public List<Member> createMembers(List<Member> newMembers) {
    List<Member> updatedMembers = new ArrayList<>();
    for(Member newMember : newMembers) {
      Member memberInDb = findMember(newMember);
      if (memberInDb != null) {
        updatedMembers.add(updateMember(newMember, memberInDb));
      } else {
        updatedMembers.add(createMember(newMember));
      }
    }
    return (List<Member>) memberRepository.saveAll(updatedMembers);
  }

  public Member updateMember(Member memberToUpdate, Member memberInDb) {
    memberInDb.setAddress(memberToUpdate.getAddress());
    memberInDb.setEmail(memberToUpdate.getEmail());
    memberInDb.setPhoneNumber(memberInDb.getPhoneNumber());
    memberInDb.setDurationOfMemberInDays(calcMembershipDuration(memberInDb.getStartOfMember()));
    return memberInDb;
  }

  public Member findMember(Member memberToFind) {
    Member memberInDb = findByNameAndEmail(memberToFind);
    if (memberInDb == null) {
      memberInDb = findByNameAndAddress(memberToFind);
      if (memberInDb == null) {
        memberInDb = findByNameAndPhoneNumber(memberToFind);
      }
    }
    return memberInDb;
  }

  public Member findById(long id) {
    Optional<Member> optionalMember = memberRepository.findById(id);
    return optionalMember.orElse(null);
  }

  public List<Member> findAllByName(String name) {
    return memberRepository.findAllByName(name);
  }

  public List<Member> findAllByPhoneNumber(String phoneNumber) {
    return memberRepository.findAllByPhoneNumber(phoneNumber);
  }

  private Member findByNameAndEmail(Member member) {
    return memberRepository.findByNameAndEmail(member.getName(), member.getEmail());
  }

  private Member findByNameAndAddress(Member member) {
    return memberRepository.findByNameAndEmail(member.getName(), member.getAddress());
  }

  private Member findByNameAndPhoneNumber(Member member) {
    return memberRepository.findByNameAndEmail(member.getName(), member.getPhoneNumber());
  }

  private long calcMembershipDuration(LocalDate startDate) {
    LocalDate today = LocalDate.now();
    return ChronoUnit.DAYS.between(startDate, today);
  }


}
