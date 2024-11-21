package com.keyin.domain.Tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TournamentServices {
  @Autowired
  private TournamentRepository tournamentRepository;

  public Tournament createTournament(Tournament newTournament) {
    return tournamentRepository.save(newTournament);
  }

  public Tournament findTournamentById(long id) {
    Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
    return optionalTournament.orElse(null);
  }
}
