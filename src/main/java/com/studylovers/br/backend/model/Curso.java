package com.studylovers.br.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private int cargaHoraria;

    @Column(nullable = false)
    private String nivel;

    private String imagemPath; // Caminho ou nome do arquivo salvo


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getNivel() {
        return nivel;
    }

    public String getImagemPath() {
        return imagemPath;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setImagemPath(String imagemPath) {
        this.imagemPath = imagemPath;
    }


}
