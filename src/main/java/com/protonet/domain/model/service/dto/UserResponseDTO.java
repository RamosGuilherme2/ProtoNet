package com.protonet.domain.model.service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private Long userId;
    private String username;
    private String status;
    private String address;
    private String position;
    private Long companyId;
    private String companyName;
    private LocalDate entryDate;
    private LocalDate terminationDate;
}
