package com.studylovers.br.backend.controllers;

import com.studylovers.br.backend.model.Categoria;
import com.studylovers.br.backend.model.Curso;
import com.studylovers.br.backend.repository.CategoriaRepository;
import com.studylovers.br.backend.repository.UserRepository;
import com.studylovers.br.backend.service.CategoriaService;
import com.studylovers.br.backend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;
    private final CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
        this.categoriaService = new CategoriaService();
    }


    @PostMapping
    public ResponseEntity<Curso> cadastrarCurso(
            @RequestPart("curso") Curso curso,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem,
            @RequestPart(value = "categoria_id", required = false) Long categoria_id) {
        try {
            if(categoria_id != null && categoria_id != 0)
            {
                Optional<Categoria> categoria = categoriaRepository.findById(categoria_id);

                if (!categoria.isPresent()) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }

                curso.setCategoria(categoria.get());
            }

            Curso salvo = cursoService.salvarCurso(curso, imagem);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        try {
            List<Curso> cursos = cursoService.listarCursos();
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}