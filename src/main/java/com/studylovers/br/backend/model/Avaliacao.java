package com.studylovers.br.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private int nota;

    @Column(nullable = false)
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public Curso getCurso() {
        return curso;
    }

    public User getUser() {
        return user;
    }

    public int getNota() {
        return nota;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
