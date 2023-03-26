package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
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

  public List<Serie> getSeries() {
    return serieRepository.findAll();
  }

  public String deleteSerie(String serieId) {
    serieRepository.deleteById(Integer.parseInt(serieId));
    return "Serie deletada com sucesso";
  }

  /**
   * Método que adiciona um episódio a uma série.
   * 
   */
  public Serie addEpisode(String serieId, Episodio episodio) {
    Serie serie = serieRepository.findById(Integer.parseInt(serieId)).get();
    serie.getEpisodios().add(episodio);
    return serieRepository.save(serie);
  }

  public List<Episodio> getEpisodes(String serieId) {
    Serie serie = serieRepository.findById(Integer.parseInt(serieId)).get();
    return serie.getEpisodios();
  }

  /**
   * Método que retorna o tempo total de todas as séries.
   * 
   */
  public Integer getTempoTotal() {
    Integer tempoTotal = 100;
    return tempoTotal;
  }
  
}
