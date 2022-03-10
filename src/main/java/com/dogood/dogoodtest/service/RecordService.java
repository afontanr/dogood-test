package com.dogood.dogoodtest.service;

import com.dogood.dogoodtest.dto.RecordResponse;
import java.util.List;

public interface RecordService {

    RecordResponse registerRecord(String usernameFrom, String usernameTo, String recordTypeName, Integer amount);
    List<RecordResponse> getAllRecords(String username);
}
