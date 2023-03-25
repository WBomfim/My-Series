package com.trybe.acc.java.minhasseries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private int numero;

  @Column
  private int duracaoEmMinutos;

  public Episodio(int numero, int duracaoEmMinutos) {
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public Long getId() {
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

}
