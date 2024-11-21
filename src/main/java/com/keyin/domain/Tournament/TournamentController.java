package com.keyin.domain.Tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

  @Autowired
  private TournamentServices tournamentServices;

  @PostMapping
  public Tournament postTournament(@RequestBody Tournament newTournament) {
    return tournamentServices.createTournament(newTournament);
  }

  @GetMapping
  public Tournament getTournamentById(@RequestBody long id) {
    return tournamentServices.findTournamentById(id);
  }

}
