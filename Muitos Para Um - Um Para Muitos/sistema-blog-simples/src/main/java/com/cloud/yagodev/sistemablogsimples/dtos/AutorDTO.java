package com.cloud.yagodev.sistemablogsimples.dtos;

import com.cloud.yagodev.sistemablogsimples.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AutorDTO {
    private Long id;
    private String nome;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
    }
}
