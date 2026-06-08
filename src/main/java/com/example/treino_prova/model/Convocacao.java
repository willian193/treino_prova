package com.example.treino_prova.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Convocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataConvocacao;

    @Positive(message = "Quantidade deve ser maior que zero")
    private Integer quantidade;

    @ManyToOne
    private Selecao selecao;
}
