package com.keyin.domain.Tournament;

import com.keyin.domain.Member.Member;
import com.keyin.domain.Member.MemberServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentServices {

  private final TournamentRepository tournamentRepository;
  private final MemberServices memberServices;

  @Autowired
  public TournamentServices(TournamentRepository tournamentRepository, MemberServices memberServices) {
    this.tournamentRepository = tournamentRepository;
    this.memberServices = memberServices;
  }

  public Tournament createTournament(Tournament newTournament) {
    List<Member> updatedMembers = memberServices.createMembers(newTournament.getPlayersInTournament());
    newTournament.setPlayersInTournament(updatedMembers);
    Tournament tournamentInDb = findByStartDateAndLocation(newTournament);
    if(tournamentInDb != null) {
      tournamentInDb.getPlayersInTournament().addAll(
              newTournament.getPlayersInTournament()
                      .stream()
                      .filter(member -> !tournamentInDb.getPlayersInTournament().contains(member))
                      .toList());
      newTournament = tournamentInDb;
    }

    return tournamentRepository.save(newTournament);
  }

  public Tournament addMemberToTournament(long tournamentId, Member memberToAdd) {
    Tournament tournamentInDb = findTournamentById(tournamentId);
    List<Member> membersInTournament = tournamentInDb.getPlayersInTournament();
    membersInTournament.add(memberServices.createMember(memberToAdd));
    tournamentInDb.setPlayersInTournament(membersInTournament);
    return tournamentRepository.save(tournamentInDb);
  }

  public Tournament findTournamentById(long id) {
    Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
    return optionalTournament.orElse(null);
  }

  public Tournament findByStartDateAndLocation(Tournament newTournament) {
    return tournamentRepository.findByStartDateAndLocation(newTournament.getStartDate(), newTournament.getLocation());
  }
}
