package com.keyin.domain.Member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class  MemberController {
  private final MemberServices memberServices;

  @Autowired
  public MemberController(MemberServices memberServices) {
    this.memberServices = memberServices;
  }

  @PostMapping
  public Member postMember(@RequestBody Member newMember) {
    return memberServices.createMember(newMember);
  }

  @GetMapping("/{id}")
  public Member getMemberById(@PathVariable long id) {
    return memberServices.findById(id);
  }

  @GetMapping("/name/{name}")
  public List<Member> getAllByName(@PathVariable String name) {
    return memberServices.findAllByName(name);
  }

  @GetMapping("/phone/{phoneNumber}")
  public List<Member> getAllByPhoneNumber(@PathVariable String phoneNumber) {
    return memberServices.findAllByPhoneNumber(phoneNumber);
  }
}
