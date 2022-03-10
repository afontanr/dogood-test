package com.dogood.dogoodtest.controller;

import com.dogood.dogoodtest.dto.RecordRequest;
import com.dogood.dogoodtest.dto.RecordResponse;
import com.dogood.dogoodtest.enums.RecordTypes;
import com.dogood.dogoodtest.service.RecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/api/user/{username}/records")
    public RecordResponse registerPenalty(@PathVariable("username") String usernameFrom,
            @RequestBody RecordRequest recordRequest) {
        return recordService.registerRecord(usernameFrom, recordRequest.getUserTo(),
                recordRequest.getRecordType().toUpperCase(), recordRequest.getAmount());
    }

    @GetMapping("/api/user/{username}/records")
    public List<RecordResponse> getAllRecords(@PathVariable("username") String username) {
        return recordService.getAllRecords(username);
    }
}
