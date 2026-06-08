package com.example.treino_prova.service;

import com.example.treino_prova.model.Convocacao;
import com.example.treino_prova.model.Selecao;
import com.example.treino_prova.repository.ConvocacaoRepository;
import com.example.treino_prova.repository.SelecaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConvocacaoService {

    private final ConvocacaoRepository convocacaoRepository;
    private final SelecaoRepository selecaoRepository;

    public Convocacao registrar(Convocacao convocacao) {

        Selecao selecao = selecaoRepository
                .findById(convocacao.getSelecao().getId())
                .orElseThrow(() -> new RuntimeException("Seleção não encontrada"));

        Integer saldoAtual = selecao.getJogadoresDisponiveis();

        selecao.setJogadoresDisponiveis(
                saldoAtual + convocacao.getQuantidade()
        );

        selecaoRepository.save(selecao);

        convocacao.setSelecao(selecao);

        return convocacaoRepository.save(convocacao);
    }
}