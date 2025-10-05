package com.cloud.yagodev.sistemablogsimples.dtos;

import com.cloud.yagodev.sistemablogsimples.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AutorDTOListPost {
    private Long id;
    private String nome;
    private List<PostMinimoDTO> posts = new ArrayList<>();

    public AutorDTOListPost(Autor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        // Mapeia cada entidade Post para um PostDTO
        this.posts = entity.getPosts().stream().map(PostMinimoDTO::new).collect(Collectors.toList());
    }
}
