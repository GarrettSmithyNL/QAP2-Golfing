package com.keyin.domain.Member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    return memberServices.findMemberById(id);
  }

}
