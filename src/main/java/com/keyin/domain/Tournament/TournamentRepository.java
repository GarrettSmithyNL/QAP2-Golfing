package com.keyin.domain.Tournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<TournamentRepository, Long> {
}
