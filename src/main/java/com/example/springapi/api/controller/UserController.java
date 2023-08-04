package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    // cria um objeto do tipo UserService
    private UserService userService;

    // cria um construtor para a classe UserController
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService; // atribui o objeto userService ao atributo userService da classe UserController
    }

    @GetMapping("/user") // mapeia a url http://localhost:8080/user
    public User getUser(@RequestParam Integer iid) {
    Optional user = userService.getUser(iid); // chama o método getUser da classe UserService e atribui o retorno a um objeto do tipo Optional

    if (user.isPresent()) { // se o objeto user não estiver vazio
        return (User) user.get(); // retorna o objeto user
    }

    return null; // se o objeto user estiver vazio, retorna null

    }


}
