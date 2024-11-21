package com.keyin.domain.Tournament;

import com.keyin.domain.Member.Member;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Tournament {

  @Id
  @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue=1)
  @GeneratedValue(generator = "tournament_sequence")
  private long id;

  private LocalDate startDate;
  private LocalDate endDate;
  private String Location;
  private double entryFee;
  private double prizeAmount;

  @OneToMany
  private List<Member> playersInTournament;

  public long getId() {
    return id;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getLocation() {
    return Location;
  }

  public void setLocation(String location) {
    Location = location;
  }

  public double getEntryFee() {
    return entryFee;
  }

  public void setEntryFee(double entryFee) {
    this.entryFee = entryFee;
  }

  public double getPrizeAmount() {
    return prizeAmount;
  }

  public void setPrizeAmount(double prizeAmount) {
    this.prizeAmount = prizeAmount;
  }

  public List<Member> getPlayersInTournament() {
    return playersInTournament;
  }

  public void setPlayersInTournament(List<Member> playersInTournament) {
    this.playersInTournament = playersInTournament;
  }
}
