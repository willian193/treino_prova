package com.example.treino_prova.repository;

import com.example.treino_prova.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findAllByOrderByDataPartidaDesc();

    List<Partida> findByDataPartidaBetweenOrderByDataPartidaAsc(
            LocalDate dataInicial, LocalDate dataFinal);

    @Query("SELECT p FROM Partida p " +
            "WHERE p.dataPartida BETWEEN :dataInicial AND :dataFinal " +
            "ORDER BY p.quantidade DESC")
    List<Partida> findMaisEscaladasNoPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal);

}