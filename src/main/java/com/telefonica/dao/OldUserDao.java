package com.telefonica.dao;

import com.telefonica.model.OldUser;
import com.telefonica.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public interface OldUserDao extends MongoRepository<OldUser, String> {

    OldUser findByGpExternalId(String id);
}
