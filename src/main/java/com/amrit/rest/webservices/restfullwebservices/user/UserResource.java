package com.amrit.rest.webservices.restfullwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;

    public UserResource(UserDaoService service){
        this.userDaoService=service;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAll(){
        return userDaoService.findAll();

    }
    @GetMapping(path = "/users/{id}")
    public User getSingle(@PathVariable int id){
        User user= userDaoService.findSingle(id);
        if(user == null){
            throw new UserNotFoundException("id:"+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deletebyId(id);
    }
}
