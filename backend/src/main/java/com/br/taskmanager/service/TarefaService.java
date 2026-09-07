package com.br.taskmanager.service;

import com.br.taskmanager.dto.TarefaDTO;
import com.br.taskmanager.model.tarefas.Tarefa;
import com.br.taskmanager.repository.TarefaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<?> listar(){
        return repository.findAll();
    }

    public TarefaDTO listarId( Long id){
       Tarefa tarefa = repository.findById(id)
               .orElseThrow(() -> new RuntimeException("Tarefa não encontrada "));

       return  modelMapper.map(tarefa,TarefaDTO.class);

    }

    public Tarefa criar(TarefaDTO tarefa){
        Tarefa novaTarefa = modelMapper.map(tarefa, Tarefa.class);

        return repository.save(novaTarefa);
    }

    public ResponseEntity<?> editar(Long id, TarefaDTO tarefa) {
        Optional<Tarefa> tarefaExiste = repository.findById(id);

        if (tarefaExiste.isPresent()) {

            Tarefa tarefaAtual = tarefaExiste.get();
            modelMapper.map(tarefa, tarefaAtual);
            repository.save(tarefaAtual);

            return ResponseEntity.ok("Tarefa atuaizada.");
        }

        return ResponseEntity.notFound().build();
    }

    public  ResponseEntity<?> deletar(Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);

            return ResponseEntity.ok("Tarefa deletada");
        }
        return ResponseEntity.notFound().build();
    }



}
