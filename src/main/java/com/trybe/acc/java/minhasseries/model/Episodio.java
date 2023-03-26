package com.trybe.acc.java.minhasseries.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity Episodio.
 *
 */
@Entity
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column
  private int numero;

  @Column
  private int duracaoEmMinutos;

  @JsonIgnore
  @ManyToOne
  private Serie serie;

  public Episodio() {
  }

  public Episodio(int numero, int duracaoEmMinutos) {
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  /**
   * Construtor completo.
   * 
   */
  public Episodio(Integer id, int numero, int duracaoEmMinutos, Serie serie) {
    this.id = id;
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
    this.serie = serie;
  }

  public Integer getId() {
    return id;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(int duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public Serie getSerie() {
    return serie;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }

}
