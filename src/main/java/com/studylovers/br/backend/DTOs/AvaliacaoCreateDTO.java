package com.studylovers.br.backend.DTOs;

public class AvaliacaoCreateDTO {
    private int nota;
    private String email;
    private Long cursoId;

    public int getNota() {
        return nota;
    }

    public String getEmail() {
        return email;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
