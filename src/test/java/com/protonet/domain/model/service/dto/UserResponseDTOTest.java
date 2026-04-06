package com.protonet.domain.model.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserResponseDTO - Testes unitários")
class UserResponseDTOTest {

    private UserResponseDTO dto;

    @BeforeEach
    void setUp() {
        dto = new UserResponseDTO();
    }

    @Test
    @DisplayName("Deve inicializar DTO com valores padrão")
    void testDTOInitialization() {
        assertNull(dto.getUserId());
        assertNull(dto.getUsername());
        assertNull(dto.getStatus());
        assertNull(dto.getAddress());
        assertNull(dto.getPosition());
        assertNull(dto.getCompanyId());
        assertNull(dto.getCompanyName());
        assertNull(dto.getEntryDate());
        assertNull(dto.getTerminationDate());
    }

    @Test
    @DisplayName("Deve setar e recuperar userId")
    void testSetAndGetUserId() {
        Long userId = 1L;
        dto.setUserId(userId);
        assertEquals(userId, dto.getUserId());
    }

    @Test
    @DisplayName("Deve setar e recuperar username")
    void testSetAndGetUsername() {
        String username = "João Silva";
        dto.setUsername(username);
        assertEquals(username, dto.getUsername());
    }

    @Test
    @DisplayName("Deve setar e recuperar status")
    void testSetAndGetStatus() {
        String status = "ativo";
        dto.setStatus(status);
        assertEquals(status, dto.getStatus());
    }

    @Test
    @DisplayName("Deve setar e recuperar address")
    void testSetAndGetAddress() {
        String address = "Rua A, 123";
        dto.setAddress(address);
        assertEquals(address, dto.getAddress());
    }

    @Test
    @DisplayName("Deve setar e recuperar position")
    void testSetAndGetPosition() {
        String position = "Desenvolvedor";
        dto.setPosition(position);
        assertEquals(position, dto.getPosition());
    }

    @Test
    @DisplayName("Deve setar e recuperar companyId")
    void testSetAndGetCompanyId() {
        Long companyId = 1L;
        dto.setCompanyId(companyId);
        assertEquals(companyId, dto.getCompanyId());
    }

    @Test
    @DisplayName("Deve setar e recuperar companyName")
    void testSetAndGetCompanyName() {
        String companyName = "TechCorp";
        dto.setCompanyName(companyName);
        assertEquals(companyName, dto.getCompanyName());
    }

    @Test
    @DisplayName("Deve setar e recuperar entryDate")
    void testSetAndGetEntryDate() {
        LocalDate entryDate = LocalDate.of(2023, 1, 15);
        dto.setEntryDate(entryDate);
        assertEquals(entryDate, dto.getEntryDate());
    }

    @Test
    @DisplayName("Deve setar e recuperar terminationDate")
    void testSetAndGetTerminationDate() {
        LocalDate terminationDate = LocalDate.of(2024, 12, 31);
        dto.setTerminationDate(terminationDate);
        assertEquals(terminationDate, dto.getTerminationDate());
    }

    @Test
    @DisplayName("Deve permitir terminationDate nulo")
    void testTerminationDateCanBeNull() {
        dto.setTerminationDate(null);
        assertNull(dto.getTerminationDate());
    }

    @Test
    @DisplayName("Deve preencher todos os campos corretamente")
    void testFillAllFields() {
        LocalDate entryDate = LocalDate.of(2023, 1, 15);
        LocalDate terminationDate = LocalDate.of(2024, 12, 31);

        dto.setUserId(1L);
        dto.setUsername("João Silva");
        dto.setStatus("ativo");
        dto.setAddress("Rua A, 123");
        dto.setPosition("Desenvolvedor");
        dto.setCompanyId(1L);
        dto.setCompanyName("TechCorp");
        dto.setEntryDate(entryDate);
        dto.setTerminationDate(terminationDate);

        assertEquals(1L, dto.getUserId());
        assertEquals("João Silva", dto.getUsername());
        assertEquals("ativo", dto.getStatus());
        assertEquals("Rua A, 123", dto.getAddress());
        assertEquals("Desenvolvedor", dto.getPosition());
        assertEquals(1L, dto.getCompanyId());
        assertEquals("TechCorp", dto.getCompanyName());
        assertEquals(entryDate, dto.getEntryDate());
        assertEquals(terminationDate, dto.getTerminationDate());
    }

    @Test
    @DisplayName("Deve permitir modificar valores já setados")
    void testModifyExistingValues() {
        dto.setUsername("João");
        assertEquals("João", dto.getUsername());
        
        dto.setUsername("Maria");
        assertEquals("Maria", dto.getUsername());
    }
}

