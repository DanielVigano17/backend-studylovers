package com.studylovers.br.backend.controllers;

import com.studylovers.br.backend.DTOs.AvaliacaoCreateDTO;
import com.studylovers.br.backend.model.Avaliacao;
import com.studylovers.br.backend.repository.CursoRepository;
import com.studylovers.br.backend.repository.UserRepository;
import com.studylovers.br.backend.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<?> criarAvaliacao(@RequestBody AvaliacaoCreateDTO dto) {

        System.out.println("Este é o dto: "+dto);

        // Busca o curso e o usuário pelos IDs
        var curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        var user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.getNota());
        avaliacao.setCurso(curso);
        avaliacao.setUser(user);
        avaliacao.setDataAvaliacao(LocalDateTime.now());

        Avaliacao novaAvaliacao = avaliacaoService.salvar(avaliacao);
        return ResponseEntity.ok(novaAvaliacao);
    }

    // Listar avaliações de um curso específico
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Avaliacao>> listarAvaliacoesPorCurso(@PathVariable Long cursoId) {
        List<Avaliacao> avaliacoes = avaliacaoService.listarPorCurso(cursoId);
        return ResponseEntity.ok(avaliacoes);
    }

    // Obter média das notas de um curso
    @GetMapping("/curso/{cursoId}/media")
    public ResponseEntity<Double> obterMediaPorCurso(@PathVariable Long cursoId) {
        double media = avaliacaoService.calcularMediaPorCurso(cursoId);
        return ResponseEntity.ok(media);
    }
}
