package com.keyin.domain.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
  Member findByNameAndEmail(String name, String email);
  Member findByNameAndAddress(String name, String Address);
  Member findByNameAndPhoneNumber(String name, String phoneNumber);

  List<Member> findAllByName(String name);

  List<Member> findAllByPhoneNumber(String Phone);
}
