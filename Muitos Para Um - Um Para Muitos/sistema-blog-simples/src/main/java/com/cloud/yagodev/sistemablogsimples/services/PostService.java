package com.cloud.yagodev.sistemablogsimples.services;

import com.cloud.yagodev.sistemablogsimples.dtos.PostDTO;
import com.cloud.yagodev.sistemablogsimples.dtos.PostMinimoDTO;
import com.cloud.yagodev.sistemablogsimples.model.Autor;
import com.cloud.yagodev.sistemablogsimples.model.Post;
import com.cloud.yagodev.sistemablogsimples.repositories.AutorRepository;
import com.cloud.yagodev.sistemablogsimples.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AutorRepository autorRepository;

    @Transactional
    public PostDTO save(PostDTO postDTO) {
        Post entidadePost = new Post();
        entidadePost.setTitulo(postDTO.getTitulo());
        entidadePost.setConteudo(postDTO.getConteudo());

        Autor autor = autorRepository.getReferenceById(postDTO.getAutorDTO().getId());
        entidadePost.setAutor(autor);

        entidadePost = postRepository.save(entidadePost);
        return new PostDTO(entidadePost);
    }

    @Transactional(readOnly = true)
    public PostDTO buscarPorId(Long id) {
        Optional<Post> result = postRepository.findById(id);
        return new PostDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<PostMinimoDTO> findAll() {
        List<Post> entidadePosts = postRepository.findAll();
        return entidadePosts.stream().map(item -> new PostMinimoDTO(item)).toList();
    }

}
