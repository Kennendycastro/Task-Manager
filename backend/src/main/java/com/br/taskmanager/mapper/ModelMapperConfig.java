package com.br.taskmanager.mapper;

import com.br.taskmanager.dto.TarefaDTO;
import com.br.taskmanager.model.tarefas.Tarefa;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(TarefaDTO.class, Tarefa.class)
                .addMappings(mapper ->
                        mapper.skip(Tarefa::setId)
                );

        return modelMapper;
    }
}
