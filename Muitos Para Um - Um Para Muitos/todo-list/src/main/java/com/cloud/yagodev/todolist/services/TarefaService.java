package com.cloud.yagodev.todolist.services;

import com.cloud.yagodev.todolist.dtos.TarefaDTOPadrao;
import com.cloud.yagodev.todolist.dtos.TarefaDTOSemUsuario;
import com.cloud.yagodev.todolist.model.Tarefa;
import com.cloud.yagodev.todolist.model.Usuario;
import com.cloud.yagodev.todolist.repositories.TarefaRepository;
import com.cloud.yagodev.todolist.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public TarefaDTOPadrao save(TarefaDTOPadrao tarefaDTOPadrao) {
        Tarefa entidadeTarefa = new Tarefa();
        entidadeTarefa.setDescricao(tarefaDTOPadrao.getDescricao());

        Usuario entidadeUsuario = usuarioRepository.getReferenceById(tarefaDTOPadrao.getUsuario().getId());
        entidadeTarefa.setUsuario(entidadeUsuario);
        entidadeTarefa = tarefaRepository.save(entidadeTarefa);

        return new TarefaDTOPadrao(entidadeTarefa);
    }

    @Transactional(readOnly = true)
    public List<TarefaDTOSemUsuario> findAll() {
        List<Tarefa> tarefaList = tarefaRepository.findAll();
        return tarefaList.stream().map(item -> new TarefaDTOSemUsuario(item)).toList();
    }
}
