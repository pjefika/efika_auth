package com.telefonica.dao;

import com.telefonica.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public interface GroupDao extends MongoRepository<Group, String> {

    Group findByName(String name);
}
