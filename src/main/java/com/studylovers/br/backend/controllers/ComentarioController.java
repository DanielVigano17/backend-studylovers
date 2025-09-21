package com.studylovers.br.backend.controllers;

import com.studylovers.br.backend.DTOs.CreateComentarioDTO;
import com.studylovers.br.backend.model.Comentario;
import com.studylovers.br.backend.repository.CursoRepository;
import com.studylovers.br.backend.repository.UserRepository;
import com.studylovers.br.backend.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarComentario(@RequestBody CreateComentarioDTO dto) {

        var curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        var user = userRepository.findByEmail(dto.getEmailUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setTexto(dto.getTexto());
        comentario.setCurso(curso);
        comentario.setUser(user);
        comentario.setDate(LocalDateTime.now());

        Comentario novoComentario = comentarioService.createComentario(comentario);
        return ResponseEntity.ok(novoComentario);
    }

    // Listar comentarios de um curso específico
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Comentario>> listarComentariosPorCurso(@PathVariable Long cursoId) {
        List<Comentario> comentarios = comentarioService.getComentarioByCursoId(cursoId);
        return ResponseEntity.ok(comentarios);
    }

}
