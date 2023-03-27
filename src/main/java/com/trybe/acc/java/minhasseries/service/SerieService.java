package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import java.util.List;
import java.util.Map;
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

  public String deleteSerie(Integer serieId) {
    serieRepository.deleteById(serieId);
    return "Serie deletada com sucesso";
  }

  /**
   * Método que adiciona um episódio a uma série.
   * 
   */
  public Serie addEpisode(Integer serieId, Episodio episodio) {
    Serie serie = serieRepository.findById(serieId).get();
    episodio.setSerie(serie);
    serie.adicionarEpisodio(episodio);
    return serieRepository.save(serie);
  }

  public List<Episodio> getEpisodes(Integer serieId) {
    Serie serie = serieRepository.findById(serieId).get();
    return serie.getEpisodios();
  }

  /**
   * Método que retorna o tempo total de todas as séries.
   * 
   */
  public Map<String, Integer> getTempoTotal() {
    List<Serie> series = serieRepository.findAll();

    int duracaoTotal = 0;
    for (Serie serie : series) {
      duracaoTotal += serie.getTempoTotal();
    }

    Map<String, Integer> tempoTotal = Map.of("tempoEmMinutos", duracaoTotal);
    return tempoTotal;
  }
  
}
