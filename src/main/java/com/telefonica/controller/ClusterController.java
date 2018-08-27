package com.telefonica.controller;

import com.mongodb.client.DistinctIterable;
import com.telefonica.dao.ClusterDao;
import com.telefonica.model.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Linkedin: https://www.linkedin.com/in/tiago-iwamoto/
 * System analyst
 * Java, Ruby on Rails and Php development
 * IDE: JetBrains Idea Ultimate
 * Thank you JetBrains
 * Created at: 16/08/18 - 08:46
 */
@RestController
@Service
@SuppressWarnings("all")
public class ClusterController {

    @Autowired
    private ClusterDao clusterRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/cluster/cidades")
    public ResponseEntity getCities(){
        try{
            List<String> dados = new ArrayList<>();

            DistinctIterable<String> object = mongoTemplate.getCollection("cluster")
                    .distinct("cidade", String.class);


            for (String line : object){
                dados.add(line);
            }

            return new ResponseEntity(dados, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/cidades/{cluster}")
    public ResponseEntity getCities(@PathVariable("cluster") String cluster){
        try{
            List<Cluster> cidade = clusterRepository.getCidadeByCluster(cluster);
            List<String> res = new ArrayList<>();
            for (Cluster clusterModel : cidade) {
                res.add(clusterModel.getCidade());
            }
            Set<String> retorno = new HashSet<>(res);
            res.clear();
            res.addAll(retorno);
            return new ResponseEntity(res, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/cluster/{cidade}")
    public ResponseEntity getCluster(@PathVariable("cidade") String cidade){
        try{
            List<Cluster> citie = clusterRepository.getCidadeByCluster(cidade);
            List<String> res = new ArrayList<>();
            for(Cluster cluster : citie){
                res.add(cluster.getCidade());
            }
            Set<String> retorno = new HashSet<>(res);
            retorno.clear();
            retorno.addAll(retorno);
            return new ResponseEntity(retorno, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/cluster")
    public ResponseEntity getCluster(){
        try{
            List<String> dados = new ArrayList<>();
            DistinctIterable<String> object = mongoTemplate.getCollection("cluster")
                    .distinct("cluster", String.class);
            for (String string : object) {
                dados.add(string);
            }
            return new ResponseEntity(dados, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.BAD_GATEWAY);
        }
    }
}
