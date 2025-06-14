package com.studylovers.br.backend.repository;

import com.studylovers.br.backend.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByCursoId(Long cursoId);
}

