package com.protonet.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Users (Entity) - Testes unitários")
class UsersTest {

    private Users users;

    @BeforeEach
    void setUp() {
        users = new Users();
    }

    @Test
    @DisplayName("Deve inicializar entidade com valores nulos")
    void testEntityInitialization() {
        assertNull(users.getUserId());
        assertNull(users.getUsername());
        assertNull(users.getStatus());
        assertNull(users.getAddress());
        assertNull(users.getPosition());
        assertNull(users.getCompanyId());
        assertNull(users.getCompanyName());
        assertNull(users.getEntryDate());
        assertNull(users.getTerminationDate());
    }

    @Test
    @DisplayName("Deve setar e recuperar userId")
    void testSetAndGetUserId() {
        Long userId = 1L;
        users.setUserId(userId);
        assertEquals(userId, users.getUserId());
    }

    @Test
    @DisplayName("Deve setar e recuperar username")
    void testSetAndGetUsername() {
        String username = "João Silva";
        users.setUsername(username);
        assertEquals(username, users.getUsername());
    }

    @Test
    @DisplayName("Deve setar e recuperar status")
    void testSetAndGetStatus() {
        String status = "ativo";
        users.setStatus(status);
        assertEquals(status, users.getStatus());
    }

    @Test
    @DisplayName("Deve setar e recuperar address")
    void testSetAndGetAddress() {
        String address = "Rua A, 123";
        users.setAddress(address);
        assertEquals(address, users.getAddress());
    }

    @Test
    @DisplayName("Deve setar e recuperar position")
    void testSetAndGetPosition() {
        String position = "Desenvolvedor";
        users.setPosition(position);
        assertEquals(position, users.getPosition());
    }

    @Test
    @DisplayName("Deve setar e recuperar companyId")
    void testSetAndGetCompanyId() {
        Long companyId = 1L;
        users.setCompanyId(companyId);
        assertEquals(companyId, users.getCompanyId());
    }

    @Test
    @DisplayName("Deve setar e recuperar companyName")
    void testSetAndGetCompanyName() {
        String companyName = "TechCorp";
        users.setCompanyName(companyName);
        assertEquals(companyName, users.getCompanyName());
    }

    @Test
    @DisplayName("Deve setar e recuperar entryDate")
    void testSetAndGetEntryDate() {
        LocalDate entryDate = LocalDate.of(2023, 1, 15);
        users.setEntryDate(entryDate);
        assertEquals(entryDate, users.getEntryDate());
    }

    @Test
    @DisplayName("Deve setar e recuperar terminationDate")
    void testSetAndGetTerminationDate() {
        LocalDate terminationDate = LocalDate.of(2024, 12, 31);
        users.setTerminationDate(terminationDate);
        assertEquals(terminationDate, users.getTerminationDate());
    }

    @Test
    @DisplayName("Deve permitir terminationDate nulo")
    void testTerminationDateCanBeNull() {
        users.setTerminationDate(null);
        assertNull(users.getTerminationDate());
    }

    @Test
    @DisplayName("Deve preencher todos os campos corretamente")
    void testFillAllFields() {
        LocalDate entryDate = LocalDate.of(2023, 1, 15);
        LocalDate terminationDate = LocalDate.of(2024, 12, 31);

        users.setUserId(1L);
        users.setUsername("João Silva");
        users.setStatus("ativo");
        users.setAddress("Rua A, 123");
        users.setPosition("Desenvolvedor");
        users.setCompanyId(1L);
        users.setCompanyName("TechCorp");
        users.setEntryDate(entryDate);
        users.setTerminationDate(terminationDate);

        assertEquals(1L, users.getUserId());
        assertEquals("João Silva", users.getUsername());
        assertEquals("ativo", users.getStatus());
        assertEquals("Rua A, 123", users.getAddress());
        assertEquals("Desenvolvedor", users.getPosition());
        assertEquals(1L, users.getCompanyId());
        assertEquals("TechCorp", users.getCompanyName());
        assertEquals(entryDate, users.getEntryDate());
        assertEquals(terminationDate, users.getTerminationDate());
    }

    @Test
    @DisplayName("Deve permitir modificar valores já setados")
    void testModifyExistingValues() {
        users.setUsername("João");
        assertEquals("João", users.getUsername());

        users.setUsername("Maria");
        assertEquals("Maria", users.getUsername());
    }

    @Test
    @DisplayName("Deve suportar diferentes datas")
    void testDifferentDates() {
        LocalDate date1 = LocalDate.of(2020, 1, 1);
        LocalDate date2 = LocalDate.of(2025, 12, 31);

        users.setEntryDate(date1);
        users.setTerminationDate(date2);

        assertEquals(date1, users.getEntryDate());
        assertEquals(date2, users.getTerminationDate());
    }

    @Test
    @DisplayName("Deve suportar diferentes status")
    void testDifferentStatus() {
        users.setStatus("ativo");
        assertEquals("ativo", users.getStatus());

        users.setStatus("inativo");
        assertEquals("inativo", users.getStatus());

        users.setStatus("licença");
        assertEquals("licença", users.getStatus());
    }
}

