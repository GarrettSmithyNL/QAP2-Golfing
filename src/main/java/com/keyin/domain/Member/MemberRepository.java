package com.keyin.domain.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
  Member findByNameAndEmail(String name, String email);
  Member findByNameAndAddress(String name, String Address);
  Member findByNameAndPhoneNumber(String name, String phoneNumber);
}
