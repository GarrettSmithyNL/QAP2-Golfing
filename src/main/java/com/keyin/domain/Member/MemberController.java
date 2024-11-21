package com.keyin.domain.Member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
  @Autowired
  private MemberServices memberServices;

  @PostMapping
  public Member createMember(@RequestBody Member newMember) {
    return memberServices.createMember(newMember);
  }

  @GetMapping
  public Member findMemberById(@RequestBody long id) {
    return memberServices.findMemberById(id);
  }

}
