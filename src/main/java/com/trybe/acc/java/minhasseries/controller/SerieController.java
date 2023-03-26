package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @DeleteMapping("/{serie_id}")
  public ResponseEntity<String> deleteSerie(@RequestParam String serieId) {
    return ResponseEntity.ok().body(serieService.deleteSerie(serieId));
  }

  @PostMapping("/{serie_id}/episodios")
  public ResponseEntity<Serie> addEpisode(
      @RequestParam String serieId, @RequestBody Episodio episodio
  ) {
    return ResponseEntity.ok().body(serieService.addEpisode(serieId, episodio));
  }

  @GetMapping("/{serie_id}/episodios")
  public ResponseEntity<List<Episodio>> getEpisodes(@RequestParam String serieId) {
    return ResponseEntity.ok().body(serieService.getEpisodes(serieId));
  }
  
  @GetMapping("/tempo")
  public ResponseEntity<Integer> getTempoTotal() {
    return ResponseEntity.ok().body(serieService.getTempoTotal());
  }

}