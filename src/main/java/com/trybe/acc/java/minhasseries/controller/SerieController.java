package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataError;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe SerieController.
 * 
 */
@RestController
@RequestMapping("/series")
public class SerieController {
  
  @Autowired
  private SerieService serieService;

  @PostMapping
  public ResponseEntity<Serie> createSerie(@RequestBody Serie serie) {
    return ResponseEntity.ok().body(serieService.createSerie(serie));
  }

  @GetMapping
  public ResponseEntity<List<Serie>> getSeries() {
    return ResponseEntity.ok().body(serieService.getSeries());
  }

  @DeleteMapping("/{serieId}")
  public ResponseEntity<String> deleteSerie(@PathVariable Integer serieId) {
    return ResponseEntity.ok().body(serieService.deleteSerie(serieId));
  }

  @PostMapping("/{serieId}/episodios")
  //@CircuitBreaker(name = "addEpisode", fallbackMethod = "addEpisodeFallback")
  public ResponseEntity<Serie> addEpisode(
      @PathVariable Integer serieId, @RequestBody Episodio episodio
  ) {
    return ResponseEntity.ok().body(serieService.addEpisode(serieId, episodio));
  }

  @GetMapping("/{serieId}/episodios")
  public ResponseEntity<List<Episodio>> getEpisodes(@PathVariable Integer serieId) {
    return ResponseEntity.ok().body(serieService.getEpisodes(serieId));
  }
  
  @GetMapping("/tempo")
  public ResponseEntity<Map<String, Integer>> getTempoTotal() {
    return ResponseEntity.ok().body(serieService.getTempoTotal());
  }

  public ResponseEntity<DataError> addEpisodeFallback(Exception exception) {
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
        .body(new DataError("Serviço temporariamente indisponível"));
  }

}
