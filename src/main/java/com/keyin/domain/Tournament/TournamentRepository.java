package com.keyin.domain.Tournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
  Tournament findByStartDateAndLocation(LocalDate startDate, String location);
  List<Tournament> findAllByStartDate(LocalDate startDate);
}
