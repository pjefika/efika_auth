package com.telefonica.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.telefonica.dao.GroupDao;
import com.telefonica.dao.UserDao;
import com.telefonica.model.Group;
import com.telefonica.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/

@RestController
@Service
@SuppressWarnings("all")
public class UserController {

    @Autowired private UserDao userDao;
    @Autowired private GroupDao groupDao;
    private HashMap<String, Object> eReturn = null;

    @GetMapping(value = "/user/all")
    public ResponseEntity getAll(){
        try{
            List<User> users = userDao.findAll();
            return new ResponseEntity(users, HttpStatus.OK);
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity getOne(@PathVariable(name = "id") String id){
        try{
            User user = userDao.findById(id).get();
            return new ResponseEntity(user, HttpStatus.OK);
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping(value = "/user")
    public ResponseEntity save(@RequestBody User user){
        try{
            User uExists = userDao.findByName(user.getName());
            if(uExists != null){
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Este grupo já existe !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }

            List<Group> fGroups = new ArrayList<>();
            for (Group group : user.getGroups()){
                Group eGroup = groupDao.findByName(group.getName());
                if(eGroup == null){
                    eReturn = new HashMap<>();
                    eReturn.put("code", 400);
                    eReturn.put("msg", "O grupo " + group.getName() + " não existe !");
                    return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
                }
                fGroups.add(eGroup);
            }

            Set<Group> sSGroups = fGroups.stream()
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(Comparator.comparing(Group::getName))));
            fGroups = new ArrayList<>(sSGroups);
            user.setGroups(fGroups);;
            user.setDateCreated(new Date());
            user.setDateUpdated(new Date());
            user.setUpdated(true);
            user.setCreator(1);
            User sUser = userDao.save(user);
            if(sUser != null){
                HashMap<String, Object> map = new HashMap<>();
                map.put("username", user.getMatricula());
                map.put("password", user.getPassword());
                JSONObject login = new JSONObject(map);
                //HttpResponse<JsonNode> jsonResponse = Unirest.post("http://localhost:8080/logar")
                HttpResponse<JsonNode> jsonResponse = Unirest.post("http://127.0.0.1:9001/efika/logar")
                        .header("Content-Type", "application/json")
                        .body(login)
                        .asJson();
                eReturn = new HashMap<>();
                eReturn.put("user", sUser);
                eReturn.put("token", jsonResponse.getHeaders().get("Authorization"));
                return new ResponseEntity(sUser, HttpStatus.CREATED);
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

    @PutMapping(value = "/user")
    public ResponseEntity update(@RequestBody User user){
        try{
//            User gExists = userDao.findById(user.getId()).get();
//            if(gExists == null){
//                eReturn = new HashMap<>();
//                eReturn.put("code", 400);
//                eReturn.put("msg", "Este usuário não foi localizado !");
//                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
//            }
            List<Group> fGroups = new ArrayList<>();
            for (Group group : user.getGroups()){
                Group eGroup = groupDao.findByName(group.getName());
                if(eGroup == null){
                    eReturn = new HashMap<>();
                    eReturn.put("code", 400);
                    eReturn.put("msg", "O grupo " + group.getName() + " não existe !");
                    return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
                }
                fGroups.add(eGroup);
            }
            Set<Group> sSGroups = fGroups.stream()
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(Comparator.comparing(Group::getName))));
            fGroups = new ArrayList<>(sSGroups);
            user.setGroups(fGroups);
            user.setDateUpdated(new Date());
            user.setUpdated(true);
            User sUser = userDao.save(user);
            if(sUser != null){
                return new ResponseEntity(sUser, HttpStatus.OK);
            }else{
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Falha ao atualizar usuário !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity remove(@PathVariable(name = "id") String id){
        try{
            User group = userDao.findById(id).get();
            if(group == null){
                eReturn = new HashMap<>();
                eReturn.put("code", 400);
                eReturn.put("msg", "Este usuário não foi localizado !");
                return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
            }

            userDao.delete(group);
            eReturn = new HashMap<>();
            eReturn.put("code", 200);
            eReturn.put("msg", "Usuário removido com sucesso !");
            return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping(value = "/user/password")
    public ResponseEntity password(@RequestBody User user){
        try{
            User fUser = userDao.findByMatriculaAndCpf(user.getMatricula(), user.getCpf());
            if(fUser != null){
                fUser.setPassword(user.getPassword());
                User sUser = userDao.save(fUser);
                if(sUser != null){
                    return new ResponseEntity(sUser, HttpStatus.OK);
                }else{
                    return new ResponseEntity(new User(), HttpStatus.BAD_REQUEST);
                }
            }else{
                eReturn = new HashMap<>();
                eReturn.put("code", 404);
                eReturn.put("msg", "Usuário não localizado !");
                return new ResponseEntity(eReturn, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

}
