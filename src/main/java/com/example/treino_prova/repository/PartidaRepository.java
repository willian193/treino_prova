package com.example.treino_prova.repository;

import com.example.treino_prova.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findAllByOrderByDataPartidaDesc();

}