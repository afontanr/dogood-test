package com.dogood.dogoodtest.dto;

public class RecordResponse {

    private String userTo;

    private String userFrom;

    private String type;

    private Integer amount;

    public RecordResponse() {
    }

    public RecordResponse(String userFrom, String userTo, String type, Integer amount) {
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.type = type;
        this.amount = amount;
    }

    public String getUserTo() {
        return userTo;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public String getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }
}
