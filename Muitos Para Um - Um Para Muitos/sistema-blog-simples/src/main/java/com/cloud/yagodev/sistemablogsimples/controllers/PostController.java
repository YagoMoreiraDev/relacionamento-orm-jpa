package com.cloud.yagodev.sistemablogsimples.controllers;

import com.cloud.yagodev.sistemablogsimples.dtos.PostDTO;
import com.cloud.yagodev.sistemablogsimples.dtos.PostMinimoDTO;
import com.cloud.yagodev.sistemablogsimples.model.Post;
import com.cloud.yagodev.sistemablogsimples.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostMinimoDTO> getPosts() {
        return postService.findAll();
    }

    @PostMapping
    public PostDTO post(@RequestBody PostDTO postDTO) {
        return postService.save(postDTO);
    }

    @GetMapping("/{id}")
    public PostDTO buscarPorId(@PathVariable Long id) {
       return postService.buscarPorId(id);
    }
}
