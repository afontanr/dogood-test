package com.dogood.dogoodtest.service.impl;

import com.dogood.dogoodtest.dto.RecordResponse;
import com.dogood.dogoodtest.entity.Record;
import com.dogood.dogoodtest.entity.RecordType;
import com.dogood.dogoodtest.entity.User;
import com.dogood.dogoodtest.enums.RecordTypes;
import com.dogood.dogoodtest.enums.RolTypes;
import com.dogood.dogoodtest.exception.DonationException;
import com.dogood.dogoodtest.exception.PenaltyException;
import com.dogood.dogoodtest.exception.RecordTypeNotFound;
import com.dogood.dogoodtest.exception.UserNotFound;
import com.dogood.dogoodtest.repository.RecordRepository;
import com.dogood.dogoodtest.repository.RecordTypeRepository;
import com.dogood.dogoodtest.repository.UserRepository;
import com.dogood.dogoodtest.service.RecordService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecordServiceImpl implements RecordService {

    RecordRepository recordRepository;
    UserRepository userRepository;
    RecordTypeRepository recordTypeRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository recordRepository,
            UserRepository userRepository,
            RecordTypeRepository recordTypeRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
        this.recordTypeRepository = recordTypeRepository;
    }

    public RecordResponse registerRecord(String usernameFrom, String usernameTo,
            String recordTypeName, Integer amount) {
        log.info("registerRecord.in");
        log.debug("registerRecord.findRecordType: {}", recordTypeName);
        RecordType recordType = recordTypeRepository.findRecordTypeByType(recordTypeName)
                .orElseThrow(() -> new RecordTypeNotFound(recordTypeName));
        log.debug("registerRecord.findUserFrom: {}", usernameFrom);
        User userFrom = userRepository.findUserByUsername(usernameFrom)
                .orElseThrow(() -> new UserNotFound(usernameFrom));
        log.debug("registerRecord.findUserTo: {}", usernameTo);
        User userTo = userRepository.findUserByUsername(usernameTo)
                .orElseThrow(() -> new UserNotFound(usernameTo));

        if (RecordTypes.DONATION.name().equals(recordType.getType())) {
            checkDonation(userFrom, amount);
        } else if (RecordTypes.PENALTY.name().equals(recordType.getType()) ||
                    RecordTypes.EARNING.name().equals(recordType.getType())) {
            checkAdmin(userFrom);
        }

        Record record = recordRepository.save(new Record(userFrom, userTo, recordType, amount));

        log.info("registerRecord.out");
        return mapRecordToRecordResponse(record);
    }

    public List<RecordResponse> getAllRecords(String username) {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFound(username));
        List<RecordResponse> response = new ArrayList<>();
        response.addAll(user.getRecordsGiven().stream().map(this::mapRecordToRecordResponse).collect(Collectors.toList()));
        response.addAll(user.getRecordsReceived().stream().map(this::mapRecordToRecordResponse).collect(Collectors.toList()));

        return response;
    }

    private void checkDonation(User user, Integer amount) {
        if (user.getTotal() < amount) {
            throw new DonationException(user.getUsername());
        }
    }

    private void checkAdmin(User user) {
        if(!RolTypes.ADMIN.name().equals(user.getRol().getName())) {
            throw new PenaltyException();
        }
    }

    private RecordResponse mapRecordToRecordResponse(Record record) {
        return new RecordResponse(record.getUserFrom().getUsername(),
                record.getUserTo().getUsername(), record.getType().getType(), record.getAmount());
    }


}
