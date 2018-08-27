package com.telefonica.util;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.telefonica.dao.UserDao;
import com.telefonica.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
@Service
//Descomentar as anotacoes abaixo para iniciar os agendamentos
//@EnableScheduling
//@Component
public class Task {

    @Autowired private UserDao userDao;

    @Scheduled(fixedDelay = 5000)
    public void sincronizaAws(){
        System.out.println("Oi - " + new Date());
        List<User> users = userDao.findAllByIsUpdated(false);
        System.out.println(users);

        HashMap<String, Object> map = new HashMap<>();
        map.put("users", users);
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.post("http://localhost:8181/user-sync/index.php")
                    .header("Content-Type", "application/json")
                    .body(map)
                    .asJson();

            JSONObject jArray = new JSONObject(jsonResponse.getBody().toString());
            List<User> nUsers = new ArrayList<>();
            for(int x = 0; x < jArray.getJSONArray("users").length(); x++){
                Gson gson = new Gson();
                User user = gson.fromJson(jArray.getJSONArray("users").get(x).toString(), User.class);
                nUsers.add(user);
            }

            nUsers.stream().forEach(user -> {
                User sUser = userDao.save(user);
                if(sUser != null){

                }else{

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
