package com.dogood.dogoodtest.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "rol")
public class Rol {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
  private List<User> users;

  public Rol() {
  }

  public Rol(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<User> getUsers() {
    return users;
  }

  @Override
  public String toString() {
    return "Rol{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
