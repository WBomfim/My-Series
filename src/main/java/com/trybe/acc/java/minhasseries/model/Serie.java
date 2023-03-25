package com.trybe.acc.java.minhasseries.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nome;

  @Column
  @OneToMany(mappedBy = "serie")
  private List<Episodio> episodios;

  public Serie(String nome) {
    this.nome = nome;
    this.episodios = new ArrayList<Episodio>();
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public void setEpisodios(List<Episodio> episodios) {
    this.episodios = episodios;
  }

}
