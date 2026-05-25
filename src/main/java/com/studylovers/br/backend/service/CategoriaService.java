package com.studylovers.br.backend.service;

import com.studylovers.br.backend.interfaces.ICategoriaService;
import com.studylovers.br.backend.model.Categoria;
import com.studylovers.br.backend.model.Curso;
import com.studylovers.br.backend.repository.CategoriaRepository;
import com.studylovers.br.backend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public List<Curso> getCursosByCategoria(Long categoriaId) {
        return List.of();
    }


}
