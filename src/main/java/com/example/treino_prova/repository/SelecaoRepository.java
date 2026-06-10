package com.example.treino_prova.repository;

import com.example.treino_prova.model.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelecaoRepository extends JpaRepository<Selecao,Long> {

    @Query("SELECT s FROM Selecao s ORDER BY s.grupo ASC, s.nome ASC")
    List<Selecao> findAllOrderByGrupo();

    List<Selecao>
    findByJogadoresDisponiveisLessThanEqualOrJogadoresDisponiveisGreaterThanEqual(
            Integer min, Integer max);

}
