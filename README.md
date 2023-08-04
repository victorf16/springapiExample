create the package com.example.springapi.**service**

```java

package com.example.springapi.service;

import com.example.springapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

             //serve para dizer que essa classe é um serviço e que
@Service    // pode ser injetada em outras classes como dependência (injeção de dependência)
public class UserService {


    private List<User> userList ; // cria objeto userList do tipo List<User>

    public UserService(){ //construtor da classe UserService, que é executado quando a classe é instanciada ))

    userList = new ArrayList<>(); // cria um novo ArrayList e atribui a ele o objeto userList, ArrayList é uma classe
                                  // para criar um novo ArrayList, é necessário utilizar o operador new e o construtor
                                  // da classe ArrayList alem do tipo de dado que será armazenado na lista, no caso User
                                  // o construtor da classe ArrayList não recebe nenhum parâmetro e por isso não é
                                  // neste momento necessário passar nenhum valor entre os parênteses

    User user1 = new User(1,"John","20","madarauchiha@uol.com");
    User user2 = new User(2,"Mary","21","uzumakinaruto@gmail.com");
    User user3 = new User(3,"Peter","22","obito@gmail.com");
    User user4 = new User(4,"Paul","23","paulgames@nobreza.com");

    userList.addAll(Arrays.asList(user1,user2,user3,user4)); //adiciona os usuários na lista userList

    }

    public Optional<User> getUser(Integer iid) { //método getUser que retorna um objeto do tipo Optional<User> e
                                                // recebe um inteiro como parâmetro,
                                                // utilizar a url http://localhost:8080/user?iid=1 para testar
        Optional optional = Optional.empty(); // cria um objeto do tipo Optional e atribui a ele um valor vazio

        for (User user : userList) { //percorre a lista userList
            if (user.getId() == iid) { //se o id do usuário for igual ao id passado como parâmetro
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;

    }
}

```



create the package **api**

![image](https://github.com/victorf16/springapiExample/assets/28166733/cfbf15b6-0b0e-4713-803b-abae6e262288)



create the package **controller inside the package api**
![image](https://github.com/victorf16/springapiExample/assets/28166733/89327f0b-e491-4a67-b321-458b2daf806a)


create the package **model** inside the package api
![image](https://github.com/victorf16/springapiExample/assets/28166733/e1bdfe68-4393-4e34-9b00-71c2802ca490)


Create a new class UserController in controller package and add code below 


```java

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


```



 


