package com.studylovers.br.backend.service;


import com.studylovers.br.backend.model.Curso;
import com.studylovers.br.backend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    private String uploadDir = "C:\\Users\\Daniel\\Documents\\Backend-StudyLovers\\src\\main\\resources\\static";

    public Curso salvarCurso(Curso curso, MultipartFile imagem) throws IOException {
        if (imagem != null && !imagem.isEmpty()) {
            // Pasta externa na raiz do projeto
            String uploadDir = System.getProperty("user.dir") + File.separator + "uploads";
            File diretorio = new File(uploadDir);

            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            // Gera um nome seguro para o arquivo
            String nomeArquivo = System.currentTimeMillis() + "_" + StringUtils.cleanPath(imagem.getOriginalFilename());
            File destino = new File(uploadDir + File.separator + nomeArquivo);

            // Salva o arquivo
            imagem.transferTo(destino);

            // Guarda apenas o nome para gerar a URL depois
            curso.setImagemPath(nomeArquivo);
        }

        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }


}