package com.br.taskmanager.cotroller;

import com.br.taskmanager.config.TokenService;
import com.br.taskmanager.dto.AutenticatedDTO;
import com.br.taskmanager.dto.LoginResponseDTO;
import com.br.taskmanager.dto.RegisterDTO;
import com.br.taskmanager.model.user.Usuario;
import com.br.taskmanager.repository.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticatedController {

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AutenticatedDTO data){

        var loginuser = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(loginuser);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public  ResponseEntity resgister(@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByemail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedSenha = new BCryptPasswordEncoder().encode(data.senha());
        Usuario novousuario = new Usuario(data.nome(), data.email(), encryptedSenha,data.role());

        this.userRepository.save(novousuario);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deletar")
    public void deletar(Long id){

    }


}
