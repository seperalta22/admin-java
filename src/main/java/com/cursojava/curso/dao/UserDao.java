package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {

    List<User> getUsers ();

    void deleteUser(Long id);

    void registerUser(User user);

    boolean  getUserByCredentials(User user) ;



}


