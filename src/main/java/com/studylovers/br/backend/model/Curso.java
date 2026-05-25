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

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String url;

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @ManyToOne()
    @JoinColumn(name = "categoria_id", nullable = true)
    private Categoria categoria;

    public Long getCategoria_id() {
        return (this.categoria != null) ? this.categoria.getId() : null;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

    @Transient
    private Long categoria_id;

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

    public String getProvider() {
        return provider;
    }

    public String getUrl() {return url;}

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

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
