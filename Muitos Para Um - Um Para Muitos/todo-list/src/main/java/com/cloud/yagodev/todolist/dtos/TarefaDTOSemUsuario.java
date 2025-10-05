package com.cloud.yagodev.todolist.dtos;

import com.cloud.yagodev.todolist.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TarefaDTOSemUsuario {
    private Long id;
    private String descricao;

    public TarefaDTOSemUsuario(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.descricao = tarefa.getDescricao();
    }
}
