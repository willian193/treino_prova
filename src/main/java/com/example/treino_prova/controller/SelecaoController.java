package com.example.treino_prova.controller;

import com.example.treino_prova.model.Selecao;
import com.example.treino_prova.repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/selecoes")
@RequiredArgsConstructor
public class SelecaoController {

    private final SelecaoRepository selecaoRepository;

    @GetMapping
    public List<Selecao> listar() {
        return selecaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Selecao> cadastrar(
            @Valid @RequestBody Selecao selecao) {

        return ResponseEntity
                .status(201)
                .body(selecaoRepository.save(selecao));
    }
}
