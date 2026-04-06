package com.protonet.domain.model.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserRequestDTO - Testes unitários")
class UserRequestDTOTest {

    private UserRequestDTO dto;

    @BeforeEach
    void setUp() {
        dto = new UserRequestDTO();
    }

    @Test
    @DisplayName("Deve inicializar DTO com userId nulo")
    void testDTOInitialization() {
        assertNull(dto.getUserId());
    }

    @Test
    @DisplayName("Deve setar e recuperar userId")
    void testSetAndGetUserId() {
        Long userId = 1L;
        dto.setUserId(userId);
        assertEquals(userId, dto.getUserId());
    }

    @Test
    @DisplayName("Deve aceitar diferentes valores de userId")
    void testMultipleUserIds() {
        dto.setUserId(1L);
        assertEquals(1L, dto.getUserId());

        dto.setUserId(999L);
        assertEquals(999L, dto.getUserId());

        dto.setUserId(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, dto.getUserId());
    }

    @Test
    @DisplayName("Deve permitir userId nulo")
    void testUserIdCanBeNull() {
        dto.setUserId(null);
        assertNull(dto.getUserId());
    }

    @Test
    @DisplayName("Deve modificar userId existente")
    void testModifyUserId() {
        dto.setUserId(1L);
        assertEquals(1L, dto.getUserId());

        dto.setUserId(2L);
        assertEquals(2L, dto.getUserId());
    }

    @Test
    @DisplayName("Deve usar getter e setter corretamente")
    void testGetterAndSetterConsistency() {
        Long testId = 42L;
        dto.setUserId(testId);
        
        Long retrieved = dto.getUserId();
        assertEquals(testId, retrieved);
    }
}

