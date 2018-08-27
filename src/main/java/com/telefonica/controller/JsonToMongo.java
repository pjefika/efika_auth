package com.telefonica.controller;

import com.google.gson.Gson;
import com.telefonica.dao.OldUserDao;
import com.telefonica.model.OldUser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
@RestController
public class JsonToMongo {

    @Autowired
    private OldUserDao oldUserDao;

    @GetMapping(value = "/convert")
    public ResponseEntity convert(){
        File folder = new File("C:\\Users\\A0079821\\Desktop\\json");
        File[] listOfFiles = folder.listFiles();
        List<OldUser> oUsers = new ArrayList<>();

        for(File f : listOfFiles){
            Path path = Paths.get(f.getPath());
            StringBuilder sb = new StringBuilder();
            try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
                lines.forEach(line -> {
                    sb.append(line);
                });
                JSONObject user = new JSONObject(sb.toString());
                //JSONArray array = new JSONArray(user.get("users"));

                System.out.println(user.getJSONArray("users").length());
                for(int x = 0; x < user.getJSONArray("users").length(); x++){
                    Gson gson = new Gson();
                    JSONObject jObj = new JSONObject(user.getJSONArray("users").get(x).toString());
                    OldUser oldUser = gson.fromJson(jObj.toString(), OldUser.class);
                    System.out.println(oldUser.toString());
                    oUsers.add(oldUser);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        oUsers.stream().forEach(oUser -> {
            OldUser found = oldUserDao.findByGpExternalId(oUser.getGpExternalId());
            if(found == null){
                oldUserDao.save(oUser);
            }else{
                System.out.println("NON");
            }

        });

        return new ResponseEntity("Concluído", HttpStatus.OK);
    }


}
