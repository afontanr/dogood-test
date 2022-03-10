package com.dogood.dogoodtest.dto;

public class RankingResponse {

    private String username;

    private Integer points;

    public RankingResponse() {
    }

    public RankingResponse(String username, Integer points) {
        this.username = username;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPoints() {
        return points;
    }
}
