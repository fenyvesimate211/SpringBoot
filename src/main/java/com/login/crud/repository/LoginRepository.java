package com.login.crud.repository;

import com.login.crud.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Login,Integer> {
}
