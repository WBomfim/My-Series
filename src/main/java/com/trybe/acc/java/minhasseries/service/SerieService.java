package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe SerieService.
 * 
 */
@Service
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;

  public Serie createSerie(Serie serie) {
    return serieRepository.save(serie);
  }
  
}
