package com.studylovers.br.backend.interfaces;

import com.studylovers.br.backend.model.Comentario;

import java.util.List;

public interface IComentarioService {
    public Comentario getComentarioById(Long id);
    public Comentario createComentario(Comentario comentario);
    public List<Comentario> getComentarioByCursoId(Long id);
}
