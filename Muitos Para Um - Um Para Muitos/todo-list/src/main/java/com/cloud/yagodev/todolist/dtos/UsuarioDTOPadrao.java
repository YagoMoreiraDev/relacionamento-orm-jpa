package com.cloud.yagodev.todolist.dtos;

import com.cloud.yagodev.todolist.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UsuarioDTOPadrao {
    private Long id;
    private String nome;

    public UsuarioDTOPadrao(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }
}
