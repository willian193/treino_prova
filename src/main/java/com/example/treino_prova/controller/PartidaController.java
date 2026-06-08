package com.example.treino_prova.controller;

import com.example.treino_prova.model.Partida;
import com.example.treino_prova.repository.PartidaRepository;
import com.example.treino_prova.service.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaService partidaService;
    private final PartidaRepository partidaRepository;

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
}