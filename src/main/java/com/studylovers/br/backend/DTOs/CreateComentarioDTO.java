package com.studylovers.br.backend.DTOs;

public class CreateComentarioDTO {

    private String texto;
    private Long cursoId;
    private String emailUsuario;

    @Override
    public String toString() {
        return "CreateComentarioDTO{" +
                "texto='" + texto + '\'' +
                ", cursoId=" + cursoId +
                ", emailUsuario='" + emailUsuario + '\'' +
                '}';
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public String getTexto() {
        return texto;
    }

}
