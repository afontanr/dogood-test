package com.dogood.dogoodtest.service.impl;

import com.dogood.dogoodtest.dto.RankingResponse;
import com.dogood.dogoodtest.entity.User;
import com.dogood.dogoodtest.enums.RolTypes;
import com.dogood.dogoodtest.repository.RolRepository;
import com.dogood.dogoodtest.repository.UserRepository;
import com.dogood.dogoodtest.service.UserService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    RolRepository rolRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }

    public List<RankingResponse> generateRanking() {
        return userRepository.findAll().stream().filter(x -> x.getRol().getName().equals( RolTypes.PLAYER.name())).map(this::mapUserToRankingResponse)
                .sorted(Comparator.comparingInt(RankingResponse::getPoints).reversed()).collect( Collectors.toList());
    }

    private RankingResponse mapUserToRankingResponse(User user) {
        return new RankingResponse(user.getUsername(), user.getTotal());
    }
}
