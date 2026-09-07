package com.br.taskmanager.model.tarefas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tarefa_comum")
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtarefa")
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="conteudo")
    private String conteudo;

    @Column(name="concluida", nullable = false)
    private boolean concluida;

    //Uma tarefa comum é só uma tarefa que a prioridade é nenhuma.
    @Column(name="prioridade")
    @Enumerated(EnumType.STRING)
    private Prioridades prioridade;

    public  Tarefa(){}

    public Tarefa(Long id, String titulo, String conteudo, boolean concluida, Prioridades prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.concluida = concluida;
        this.prioridade = prioridade;
    }
}
