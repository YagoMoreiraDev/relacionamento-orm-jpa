package com.cloud.yagodev.sistemablogsimples.dtos;

import com.cloud.yagodev.sistemablogsimples.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostMinimoDTO {
    private Long id;
    private String titulo;
    private String conteudo;

    public PostMinimoDTO(Post post) {
        this.id = post.getId();
        this.titulo = post.getTitulo();
        this.conteudo = post.getConteudo();
    }
}
