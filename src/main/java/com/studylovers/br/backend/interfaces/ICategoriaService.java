package com.studylovers.br.backend.interfaces;

import com.studylovers.br.backend.model.Categoria;
import com.studylovers.br.backend.model.Curso;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> getAllCategorias();

    Categoria getCategoriaById(Long id);

    List<Curso> getCursosByCategoria(Long categoriaId);
}

