package com.cloud.yagodev.todolist.controllers;

import com.cloud.yagodev.todolist.dtos.TarefaDTOPadrao;
import com.cloud.yagodev.todolist.dtos.TarefaDTOSemUsuario;
import com.cloud.yagodev.todolist.repositories.TarefaRepository;
import com.cloud.yagodev.todolist.services.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public TarefaDTOPadrao criarTarefa(@RequestBody TarefaDTOPadrao tarefaDTOPadrao) {
        return tarefaService.save(tarefaDTOPadrao);
    }

    @GetMapping
    public List<TarefaDTOSemUsuario> buscarTodas() {
        return tarefaService.findAll();
    }
}
