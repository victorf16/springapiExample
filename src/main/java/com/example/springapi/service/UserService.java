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

    public UserService(){ //construtor da classe UserService

    userList = new ArrayList<>(); //cria a lista de usuários na variavel userList, que é do tipo List<User>

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
