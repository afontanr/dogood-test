package com.dogood.dogoodtest.service;

import com.dogood.dogoodtest.dto.RankingResponse;
import java.util.List;

public interface UserService {

    List<RankingResponse> generateRanking();

}
