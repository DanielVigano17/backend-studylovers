package com.studylovers.br.backend.controllers;

import com.studylovers.br.backend.interfaces.ICategoriaService;
import com.studylovers.br.backend.model.Curso;
import com.studylovers.br.backend.repository.CategoriaRepository;
import com.studylovers.br.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")

public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ICategoriaService iCategoriaService;

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Curso>> ListarCursosPorCategoria(@PathVariable Long categoriaId) {
        List<Curso> ListaDeCursos = categoriaService.getCursosByCategoria(categoriaId);
        return ResponseEntity.ok(ListaDeCursos);
    }

}
