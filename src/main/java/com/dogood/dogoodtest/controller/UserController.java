package com.dogood.dogoodtest.controller;

import com.dogood.dogoodtest.dto.RankingResponse;
import com.dogood.dogoodtest.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/api/users/ranking")
    public List<RankingResponse> generateRanking() {
        return userService.generateRanking();
    }
}
