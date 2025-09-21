package com.studylovers.br.backend.service;

import com.studylovers.br.backend.interfaces.IComentarioService;
import com.studylovers.br.backend.model.Comentario;
import com.studylovers.br.backend.repository.AvaliacaoRepository;
import com.studylovers.br.backend.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public Comentario getComentarioById(Long id) {
        return comentarioRepository.findById(id).get();
    }

    @Override
    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public List<Comentario> getComentarioByCursoId(Long id) {
        return comentarioRepository.findByCursoId(id);
    }
}
