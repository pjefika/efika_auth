package com.telefonica.dao;

import com.telefonica.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public interface UserDao extends MongoRepository<User, String> {
    User findByName(String name);

    User findByMatriculaAndPassword(String matricula, String password);

    User findByMatricula(String matricula);

    List<User> findAllByIsUpdated(Boolean active);
}
