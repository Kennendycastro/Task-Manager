package com.br.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")

public class ControllerTest {
    @GetMapping("/resposta")
    public String resposta(){
        return "Pagina respondeu.";
    }

}
