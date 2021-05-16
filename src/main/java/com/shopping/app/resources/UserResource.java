package com.shopping.app.resources;


import com.shopping.app.domain.User;
import com.shopping.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

@RequestMapping("/api/users")
public class UserResource {


    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);
        Map<String,String> map = new HashMap<>();
        map.put("message","Login with success");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @GetMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String,Object> userMap){
        String firstname = (String) userMap.get("firstname");
        String lastname = (String) userMap.get("lastname");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(firstname, lastname, email, password);
        Map<String,String> map = new HashMap<>();
        map.put("message","success");
        return new ResponseEntity<>(map, HttpStatus.OK);

    }
}
