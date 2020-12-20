package com.login.crud.controller;

import com.login.crud.model.Login;
import com.login.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CrudRestController {

    @Autowired
    private CrudService service;

    ArrayList<Login> logins;

    @GetMapping("/getloginlist")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Login> fetchLoginList(){
        logins = new ArrayList<Login>();
        logins = service.fetchLoginFromRepository();
        return logins;
    }

    @PostMapping("/addlogin")
    @CrossOrigin(origins = "http://localhost:4200")
    public Login saveLogin(@RequestBody Login login){
       return service.persistLoginIntoRepository(login);
    }

    @GetMapping("/getloginbyid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Login fetchLoginById(@PathVariable int id){
        return service.fetchLoginFromRepositoryById(id).get();
    }

    @PostMapping("/editlogin")
    @CrossOrigin(origins = "http://localhost:4200")
    public String updateLogin(@RequestBody Login login){
        return service.updateLoginInRepository(login);
    }

    @DeleteMapping("/login/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteLogin(@PathVariable int id){
        return service.deleteLoginById(id);
    }

}
