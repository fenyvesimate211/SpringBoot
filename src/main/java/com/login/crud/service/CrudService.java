package com.login.crud.service;

import com.login.crud.model.Login;
import com.login.crud.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class CrudService {

    @Autowired
    private LoginRepository repo;

    private Login loginToUpdate;

    public ArrayList<Login> fetchLoginFromRepository(){
        return (ArrayList<Login>) repo.findAll();
    }

    public Login persistLoginIntoRepository(Login login){
       return repo.save(login);
    }

    public Optional<Login> fetchLoginFromRepositoryById(int id)
    {
        return repo.findById(id);
    }

    public String updateLoginInRepository(Login login) {
        try {
            loginToUpdate = repo.getOne(login.getId());

            loginToUpdate.setFirstname(login.getFirstname());
            loginToUpdate.setLastname(login.getLastname());
            loginToUpdate.setEmail(login.getEmail());
            loginToUpdate.setPassword(login.getPassword());

            repo.save(loginToUpdate);

            return "Login Updated";
        }catch (Exception e){
            return "There is no login registered under the ID: "+login.getId()+"\nMake sure you you send a valid login!";
        }
    }

     public String deleteLoginById(int id) {
        try
        {
            repo.deleteById(id);
            return "Login Deleted Successfully";
        }catch (Exception e){
            return "Login not found";
        }

    }
}
