package com.cursojava.curso.dao;



import com.cursojava.curso.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
            String query = "FROM User";
            return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void registerUser(User user) {
        entityManager.persist(user);
    }


    public boolean getUserByCredentials(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> list= entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if(list.size()==0){
            return false;
        }
        else{
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            return argon2.verify(list.get(0).getPassword(), user.getPassword());
        }

//        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
//        return argon2.verify(list.get(0).getPassword(), user.getPassword()); //comparing the password with the hash



    }


}


