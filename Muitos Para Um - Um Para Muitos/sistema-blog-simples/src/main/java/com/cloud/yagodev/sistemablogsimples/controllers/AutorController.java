package com.cloud.yagodev.sistemablogsimples.controllers;

import com.cloud.yagodev.sistemablogsimples.dtos.AutorDTO;
import com.cloud.yagodev.sistemablogsimples.dtos.AutorDTOListPost;
import com.cloud.yagodev.sistemablogsimples.model.Autor;
import com.cloud.yagodev.sistemablogsimples.services.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {
    private final AutorService autorService;

    @PostMapping
    public AutorDTO save(@RequestBody AutorDTO autorDTO) {
        return autorService.criarAutor(autorDTO);
    }

    @GetMapping
    public List<AutorDTO> findAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public AutorDTO findById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @GetMapping(value = "/com-post/{id}")
    public AutorDTOListPost buscarPorIdComPosts(@PathVariable Long id) {
        AutorDTOListPost autorDTO = autorService.buscarPorIdComPosts(id);
        return autorDTO;
    }

    @GetMapping("/com-posts-paginado")
    public Page<AutorDTOListPost> buscarTodosComPostsPaginado(Pageable pageable) {
        Page<AutorDTOListPost> pagina = autorService.buscarTodosComPostsPaginado(pageable);
        return pagina;
    }
}
