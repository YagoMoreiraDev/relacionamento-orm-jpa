package com.cloud.yagodev.todolist.dtos;

import com.cloud.yagodev.todolist.model.Tarefa;
import com.cloud.yagodev.todolist.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TarefaDTOPadrao {
    private Long id;
    private String descricao;
    private UsuarioDTOPadrao usuario;

    public TarefaDTOPadrao(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.descricao = tarefa.getDescricao();
        this.usuario = new UsuarioDTOPadrao(tarefa.getUsuario());
    }
}
