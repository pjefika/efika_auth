package com.telefonica.controller;

import com.telefonica.dao.OldUserDao;
import com.telefonica.dao.UserDao;
import com.telefonica.model.OldUser;
import com.telefonica.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
@RestController
@Service
public class AuthController {

    @Autowired private UserDao userDao;
    @Autowired private OldUserDao oldUserDao;
    private HashMap<String, Object> eReturn = null;

    @PostMapping(value = "/verify")
    public ResponseEntity login(@RequestBody User user){
        try {
            User nUser = userDao.findByMatriculaAndPassword(user.getMatricula(), user.getPassword());
            if (nUser != null) {
                return new ResponseEntity(nUser, HttpStatus.OK);
            } else {
                User eUser = userDao.findByMatricula(user.getMatricula());
                if(eUser != null){
                    eReturn = new HashMap<>();
                    eReturn.put("code", 400);
                    eReturn.put("msg", "Senha incorreta !");
                    return new ResponseEntity(eReturn, HttpStatus.BAD_REQUEST);
                }
                System.out.println("Vai acessar outro banco !!");
                OldUser oUser = oldUserDao.findByGpExternalId(user.getMatricula());
                if(oUser == null){
//                    eReturn = new HashMap<>();
//                    eReturn.put("code", 404);
//                    eReturn.put("msg", "Não achou nenhum operador !");
                    return new ResponseEntity(new User(), HttpStatus.OK);
                }else{
                    User nNUser = new User();
                    nNUser.setName(oUser.getGpProviderName());
                    nNUser.setCpf(oUser.getGpXrTechCpf());
                    nNUser.setPhone(oUser.getGpProviderPhone());
                    nNUser.setEmail(oUser.getGpXrTechFieldSuperEmail());
                    nNUser.setMatricula(oUser.getGpExternalId());
                    return new ResponseEntity(nNUser, HttpStatus.OK);
                }
            }
        }catch (Exception e){
            eReturn = new HashMap<>();
            eReturn.put("code", 500);
            eReturn.put("msg", e.getMessage());
            return new ResponseEntity(eReturn, HttpStatus.BAD_GATEWAY);
        }
    }

}

