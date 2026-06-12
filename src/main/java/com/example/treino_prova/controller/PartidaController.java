package com.example.treino_prova.controller;

import com.example.treino_prova.model.Partida;
import com.example.treino_prova.repository.PartidaRepository;
import com.example.treino_prova.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaRepository partidaRepository;
    private final PartidaService partidaService;

    @GetMapping
    public List<Partida> listar() {
        return partidaRepository.findAllByOrderByDataPartidaDesc();
    }

    @PostMapping
    public ResponseEntity<Partida> registrar(
            @Valid @RequestBody Partida partida) {

        return ResponseEntity
                .status(201)
                .body(partidaService.registrar(partida));
    }

    @GetMapping("/historico")
    public List<Partida> historico(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataFinal) {
        return partidaRepository
                .findByDataPartidaBetweenOrderByDataPartidaAsc(dataInicial, dataFinal);
    }

    @GetMapping("/mais-escaladas")
    public List<Partida> maisEscaladas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
                    dataFinal) {
        return partidaRepository.findMaisEscaladasNoPeriodo(dataInicial, dataFinal);
    }


}