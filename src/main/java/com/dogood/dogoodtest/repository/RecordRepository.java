package com.dogood.dogoodtest.repository;

import com.dogood.dogoodtest.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {


}
