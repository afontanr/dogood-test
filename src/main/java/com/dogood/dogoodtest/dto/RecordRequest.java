package com.dogood.dogoodtest.dto;

public class RecordRequest {

    private String userTo;

    private Integer amount;

    private String recordType;

    public RecordRequest() {
    }

    public RecordRequest(String userTo, Integer amount, String recordType) {
        this.userTo = userTo;
        this.amount = amount;
        this.recordType = recordType;
    }

    public String getRecordType() {
        return recordType;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getUserTo() {
        return userTo;
    }
}
