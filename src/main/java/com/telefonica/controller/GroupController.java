package com.telefonica.controller;

import com.telefonica.dao.GroupDao;
import com.telefonica.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
@RestController
@Service
@SuppressWarnings("all")
public class GroupController {

    @Autowired private GroupDao groupDao;
    private HashMap<String, Object> eReturn = null;

    @GetMapping(value = "/group/all")
    public ResponseEntity getAll(){
        try{
            List<Group> groups = groupDao.findAll();
            return new ResponseEntity(groups, HttpStatus.OK);
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/group/{id}")
    public ResponseEntity getOne(@PathVariable(name = "id") String id){
        try{
            Group group = groupDao.findById(id).get();
            return new ResponseEntity(group, HttpStatus.OK);
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping(value = "/group")
    public ResponseEntity save(@RequestBody Group group){
        try{
            Group gExists = groupDao.findByName(group.getName());
            if(gExists != null){
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Este grupo já existe !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }

            Group sGroup = groupDao.save(group);
            if(sGroup != null){
                return new ResponseEntity(sGroup, HttpStatus.CREATED);
            }else{
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Falha ao criar grupo !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping(value = "/group")
    public ResponseEntity update(@RequestBody Group group){
        try{
            Group gExists = groupDao.findById(group.getId()).get();
            if(gExists == null){
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Este grupo não foi localizado !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }

            Group sGroup = groupDao.save(group);
            if(sGroup != null){
                return new ResponseEntity(sGroup, HttpStatus.CREATED);
            }else{
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Falha ao atualizar grupo !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping(value = "/group/{id}")
    public ResponseEntity remove(@PathVariable(name = "id") String id){
        try{
            Group group = groupDao.findById(id).get();
            if(group == null){
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Este grupo não foi localizado !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }

            groupDao.delete(group);
            eReturn = new HashMap<>();
            eReturn.put("code", 200);
            eReturn.put("msg", "Grupo removido com sucesso !");
            return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

}
