package com.keyin.domain.Tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public Tournament getTournamentById(@PathVariable long id) {
    return tournamentServices.findTournamentById(id);
  }

}
