package com.studylovers.br.backend.service;

import com.studylovers.br.backend.model.Avaliacao;
import com.studylovers.br.backend.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // Salvar uma nova avaliação
    public Avaliacao salvar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    // Obter todas as avaliações de um curso
    public List<Avaliacao> listarPorCurso(Long cursoId) {
        return avaliacaoRepository.findByCursoId(cursoId);
    }

    // Calcular média das avaliações de um curso
    public double calcularMediaPorCurso(Long cursoId) {
        List<Avaliacao> avaliacoes = avaliacaoRepository.findByCursoId(cursoId);
        OptionalDouble media = avaliacoes.stream()
                .mapToInt(Avaliacao::getNota)
                .average();

        return media.orElse(0.0);
    }
}
