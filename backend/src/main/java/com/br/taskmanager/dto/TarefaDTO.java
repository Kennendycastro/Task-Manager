package com.br.taskmanager.dto;

import com.br.taskmanager.model.tarefas.Prioridades;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaDTO {
    private Long id;
    private String titulo;
    private String conteudo;
    private boolean concluida = false;
    @Enumerated(EnumType.STRING)
    private Prioridades prioridade;

}
