package com.example.treino_prova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Selecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Grupo é obrigatório")
    private String grupo;

    private String fase;

    @Min(value = 0, message = "Gols marcados não pode ser negativo")
    private Integer golsMarcados;

    @Min(value = 0, message = "Gols sofridos não pode ser negativo")
    private Integer golsSofridos;

    @Positive(message = "Valor do plantel deve ser maior que zero")
    private Double valorPlantel;

    private Integer jogadoresDisponiveis = 0;
}