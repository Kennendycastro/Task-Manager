package com.br.taskmanager.dto;

import com.br.taskmanager.model.user.UserRoles;

public record RegisterDTO(String nome,String email, String senha, UserRoles role ) {

}
