package com.example.treino_prova.service;

import com.example.treino_prova.model.Partida;
import com.example.treino_prova.model.Selecao;
import com.example.treino_prova.repository.PartidaRepository;
import com.example.treino_prova.repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartidaService {

    private final PartidaRepository partidaRepository;
    private final SelecaoRepository selecaoRepository;

    public Partida registrar(Partida partida) {

        Selecao selecao = selecaoRepository
                .findById(partida.getSelecao().getId())
                .orElseThrow(() ->
                        new RuntimeException("Seleção não encontrada"));

        if (selecao.getJogadoresDisponiveis() < partida.getQuantidade()) {
            throw new RuntimeException("Quantidade indisponível de jogadores");
        }

        selecao.setJogadoresDisponiveis(
                selecao.getJogadoresDisponiveis()
                        - partida.getQuantidade()
        );

        selecaoRepository.save(selecao);

        partida.setSelecao(selecao);

        return partidaRepository.save(partida);
    }
}
