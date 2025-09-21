package com.studylovers.br.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public Curso getCurso() {
        return curso;
    }
}
