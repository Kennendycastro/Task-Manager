package com.br.taskmanager.repository.user;

import com.br.taskmanager.model.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository  extends JpaRepository<Usuario, String> {
    @Autowired
    UserDetails findByemail(String email);
}
