package com.test.persistence;

import com.test.model.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBInsert implements CommandLineRunner {

    private UserRepository userRepository;

    public DBInsert(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        User user1 = new User("Elcio Abrahão","elcioabrahao@usp.br","11984720177", "m");
        User user2 = new User("Manuel Bandeira","bandeira@passargada.org","115656565845", "m");
        User user3 = new User("Mario de Andrade","mandrade@poeta.com","565989898656", "m");
        User user4 = new User("Ligia Fagundes Teles","ligiateles@escritora.com","656567978", "f");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        this.userRepository.saveAll(users);
    }
}
