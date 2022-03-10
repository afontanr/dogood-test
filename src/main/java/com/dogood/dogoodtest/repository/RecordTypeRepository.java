package com.dogood.dogoodtest.repository;

import com.dogood.dogoodtest.entity.RecordType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordTypeRepository extends JpaRepository<RecordType, Integer> {

    Optional<RecordType> findRecordTypeByType(String type);
}
