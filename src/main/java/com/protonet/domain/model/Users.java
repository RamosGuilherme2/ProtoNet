package com.protonet.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "status")
    private String status;

    @Column(name = "address")
    private String address;

    @Column(name = "position")
    private String position;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "termination_date")
    private LocalDate terminationDate;
}

