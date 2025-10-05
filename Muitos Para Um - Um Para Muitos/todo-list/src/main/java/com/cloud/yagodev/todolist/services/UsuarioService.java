package com.cloud.yagodev.todolist.services;

import com.cloud.yagodev.todolist.dtos.UsuarioDTOPadrao;
import com.cloud.yagodev.todolist.model.Usuario;
import com.cloud.yagodev.todolist.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDTOPadrao save(UsuarioDTOPadrao usuario) {
        Usuario entidadeUsuario = new Usuario();
        entidadeUsuario.setNome(usuario.getNome());

        return new UsuarioDTOPadrao(usuarioRepository.save(entidadeUsuario));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTOPadrao> findAll() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return usuarioList.stream().map(item -> new UsuarioDTOPadrao(item)).toList();
    }
}
