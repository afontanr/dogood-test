package com.dogood.dogoodtest.entity;

import com.dogood.dogoodtest.enums.RecordTypes;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "username")
  private String username;

  @ManyToOne
  @JoinColumn(name = "rol")
  private Rol rol;

  @OneToMany(mappedBy = "userTo", cascade = CascadeType.ALL)
  private List<Record> recordsReceived;

  @OneToMany(mappedBy = "userFrom", cascade = CascadeType.ALL)
  private List<Record> recordsGiven;

  public User() {
  }

  public User(String username, Rol rol) {
    this.username = username;
    this.rol = rol;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public Rol getRol() {
    return rol;
  }

  public List<Record> getRecordsReceived() {
    return recordsReceived;
  }

  public List<Record> getRecordsGiven() {
    return recordsGiven;
  }

  public Integer getTotal() {
    Integer earnings = getRecordsReceived().stream()
            .filter(x -> x.getType().getType().equals(RecordTypes.EARNING.name())).map(
                    Record::getAmount).reduce(Integer::sum).orElse(0);

    Integer donationsGiven = getRecordsGiven().stream()
            .filter(x -> x.getType().getType().equals(RecordTypes.DONATION.name())).map(
                    Record::getAmount).reduce(Integer::sum).orElse(0);
    Integer donationsReceived = getRecordsReceived().stream()
            .filter(x -> x.getType().getType().equals(RecordTypes.DONATION.name())).map(
                    Record::getAmount).reduce(Integer::sum).orElse(0);
    Integer penalties = getRecordsReceived().stream()
            .filter(x -> x.getType().getType().equals(RecordTypes.PENALTY.name())).map(
                    Record::getAmount).reduce(Integer::sum).orElse(0);

    return (earnings + donationsReceived) - (donationsGiven + penalties);
  }
}
