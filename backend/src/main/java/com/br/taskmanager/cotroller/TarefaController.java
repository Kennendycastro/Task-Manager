package com.br.taskmanager.cotroller;

import com.br.taskmanager.dto.TarefaDTO;
import com.br.taskmanager.model.tarefas.Tarefa;
import com.br.taskmanager.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService service;

    @GetMapping("/listar")
    public List<?> listar(){
         return service.listar();
    }

    @GetMapping("/listarid/{id}")
    public ResponseEntity<TarefaDTO> listarId(@PathVariable long id){
        return ResponseEntity.ok(
                service.listarId(id)
        );
    }

    @PostMapping("/criar")
    public Tarefa criar(@RequestBody TarefaDTO tarefa){
        return service.criar(tarefa);
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable long id, @RequestBody TarefaDTO tarefa){
        return ResponseEntity.ok(service.editar(id, tarefa));
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        return service.deletar(id);
    }
}
