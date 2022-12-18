package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    //get all users
    @RequestMapping(value="api/users")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    //register a user
    @RequestMapping(value="api/users", method=RequestMethod.POST)
    public void registerUser(@RequestBody User user) { //! @RequestBody is used to get the body of the request
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDao.registerUser(user);
    }


    //delete user

    @RequestMapping(value="api/users/{id}", method= RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
    userDao.deleteUser(id);
        }



}
