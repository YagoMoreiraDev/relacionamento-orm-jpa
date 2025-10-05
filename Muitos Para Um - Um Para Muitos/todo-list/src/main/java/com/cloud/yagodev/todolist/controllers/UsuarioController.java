package com.cloud.yagodev.todolist.controllers;

import com.cloud.yagodev.todolist.dtos.UsuarioDTOPadrao;
import com.cloud.yagodev.todolist.services.UsuarioService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTOPadrao criarUsuario(@RequestBody UsuarioDTOPadrao usuarioDTOPadrao) {
        return usuarioService.save(usuarioDTOPadrao);
    }

    @GetMapping
    public List<UsuarioDTOPadrao> listarUsuarios() {
        return usuarioService.findAll();
    }
}
