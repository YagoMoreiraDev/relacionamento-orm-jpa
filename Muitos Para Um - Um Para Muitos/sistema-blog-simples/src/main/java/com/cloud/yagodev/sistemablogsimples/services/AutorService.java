package com.cloud.yagodev.sistemablogsimples.services;

import com.cloud.yagodev.sistemablogsimples.dtos.AutorDTO;
import com.cloud.yagodev.sistemablogsimples.dtos.AutorDTOListPost;
import com.cloud.yagodev.sistemablogsimples.model.Autor;
import com.cloud.yagodev.sistemablogsimples.repositories.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;
    private final PostService postService;

    @Transactional
    public AutorDTO criarAutor(AutorDTO autorDTO) {
        Autor entidadeAutor = new Autor();
        entidadeAutor.setNome(autorDTO.getNome());

        return new AutorDTO(autorRepository.save(entidadeAutor));
    }

    @Transactional(readOnly = true)
    public List<AutorDTO> findAll() {
        List<Autor> autors = autorRepository.findAll();
        return autors.stream()
                .map(item -> new AutorDTO(item))
                .toList();
    }

    @Transactional(readOnly = true)
    public AutorDTO findById(Long id) {
        Autor autor = autorRepository.findById(id).get();
        return new AutorDTO(autor);
    }

    @Transactional(readOnly = true)
    public AutorDTOListPost buscarPorIdComPosts(Long id) {
        // Usamos o novo método que garante que os posts virão na mesma query
        Autor autor = autorRepository.findByIdWithPosts(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com o ID: " + id));

        // O mapeamento para DTO é feito no construtor do DTO
        return new AutorDTOListPost(autor);
    }

    @Transactional(readOnly = true)
    public Page<AutorDTOListPost> buscarTodosComPostsPaginado(Pageable pageable) {
        // 1. Busca a página de AUTORES (sem os posts)
        Page<Autor> paginaDeAutores = autorRepository.findAll(pageable);

        // 2. Busca os posts PARA AQUELES AUTORES da página em uma única query
        List<Autor> autoresComPosts = autorRepository.findAutoresWithPosts(paginaDeAutores.getContent());

        // 3. Mapeia o resultado para o DTO.
        // O Page.map é uma forma elegante de converter o conteúdo da página.
        return paginaDeAutores.map(AutorDTOListPost::new);
    }

}
