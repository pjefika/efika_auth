package com.telefonica.dao;

import com.telefonica.model.Cluster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 16/08/18 - 08:39
 */
public interface ClusterDao extends MongoRepository<Cluster, Integer> {

    @Query("{'cidade': ?0}")
    List<Cluster> getClusterByCidade(String cidade);

    @Query("{'cluster' : ?0}")
    List<Cluster> getCidadeByCluster(String cluster);
}
