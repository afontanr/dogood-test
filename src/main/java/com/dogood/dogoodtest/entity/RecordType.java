package com.dogood.dogoodtest.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "record_type")
public class RecordType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Record> records;

    public RecordType() {
    }

    public RecordType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Record> getRecords() {
        return records;
    }
}
