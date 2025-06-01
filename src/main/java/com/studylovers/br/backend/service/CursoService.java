package com.studylovers.br.backend.service;


import com.studylovers.br.backend.model.Curso;
import com.studylovers.br.backend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    private String uploadDir = "";

    public Curso salvarCurso(Curso curso, MultipartFile imagem) throws IOException {

        if (imagem != null && !imagem.isEmpty()) {
            // Garante que o diretório existe
            File diretorio = new File(uploadDir);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            String nomeArquivo = System.currentTimeMillis() + "_" + StringUtils.cleanPath(imagem.getOriginalFilename());
            File destino = new File(uploadDir + File.separator + nomeArquivo); // garante separador correto
            imagem.transferTo(destino);
            curso.setImagemPath(nomeArquivo);
        }

        return cursoRepository.save(curso);
    }

}