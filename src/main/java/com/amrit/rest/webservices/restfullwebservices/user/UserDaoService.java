package com.amrit.rest.webservices.restfullwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();

    private static int userCount = 0;

    static {
       users.add(new User(++userCount,"Amrit", LocalDate.now().minusYears(20)));
       users.add(new User(++userCount,"Apil", LocalDate.now().minusYears(30)));
       users.add(new User(++userCount,"Ananda", LocalDate.now().minusYears(40)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findSingle(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
//        Optional<User> optionalUser = users.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst();
//        return optionalUser.orElse(null);

    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deletebyId(int id){
        users.removeIf(user -> user.getId() == id);
    }
}
