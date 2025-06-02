package com.studylovers.br.backend.controllers;

import com.studylovers.br.backend.model.Curso;
import com.studylovers.br.backend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> cadastrarCurso(
            @RequestPart("curso") Curso curso,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem) {
        try {
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