package com.studylovers.br.backend.repository;

import com.studylovers.br.backend.model.Comentario;
import com.studylovers.br.backend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByCursoId(Long cursoId);
}
