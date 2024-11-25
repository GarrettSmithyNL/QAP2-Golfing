package com.keyin.domain.Tournament;

import com.keyin.domain.Member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

  private final TournamentServices tournamentServices;

  @Autowired
  public TournamentController(TournamentServices tournamentServices) {
    this.tournamentServices = tournamentServices;
  }
  @PostMapping
  public Tournament postTournament(@RequestBody Tournament newTournament) {
    return tournamentServices.createTournament(newTournament);
  }

  @PostMapping("/{id}/add-member")
  public Tournament addMemberToTournament(@PathVariable long id, @RequestBody Member memberToAdd) {
    return tournamentServices.addMemberToTournament(id, memberToAdd);
  }

  @GetMapping("/{id}")
  public Tournament getTournamentById(@PathVariable long id) {
    return tournamentServices.findTournamentById(id);
  }

  @GetMapping("/{id}/members")
  public List<Member> getMemberByTournament(@PathVariable long id) {
    return tournamentServices.findMembersByTournament(id);
  }

  @GetMapping("/start-date/{tournamentStartDate}")
  public List<Tournament> getTournamentByStartDate(@PathVariable LocalDate tournamentStartDate) {
    return tournamentServices.findByStartDate(tournamentStartDate);
  }

  @GetMapping("/location/{location}")
  public List<Tournament> getByLocations(@PathVariable String location) {
    return tournamentServices.findByLocation(location);
  }

  @GetMapping("/members/start-date/{tournamentStartDate}")
  public List<Member> getMembersByTournamentStartDate(@PathVariable LocalDate tournamentStartDate) {
    return tournamentServices.findAllMembersByTournamentStartDate(tournamentStartDate);
  }
  

}
