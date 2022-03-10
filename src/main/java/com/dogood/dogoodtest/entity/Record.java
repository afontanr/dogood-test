package com.dogood.dogoodtest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_from")
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "user_to")
    private User userTo;

    @ManyToOne
    @JoinColumn(name = "type")
    private RecordType type;

    @Column(name = "amount")
    private Integer amount;

    public Record() {
    }

    public Record(User userFrom, User userTo, RecordType type, Integer amount) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.type = type;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public RecordType getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }
}
