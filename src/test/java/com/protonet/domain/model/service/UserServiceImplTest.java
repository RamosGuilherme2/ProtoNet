package com.protonet.domain.model.service;

import com.protonet.application.port.out.UserRepository;
import com.protonet.domain.model.Users;
import com.protonet.domain.model.service.dto.UserResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserServiceImpl - Testes unitários")
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private Users users;
    private Long userId;

    @BeforeEach
    void setUp() {
        userId = 1L;
        users = new Users();
        users.setUserId(userId);
        users.setUsername("João Silva");
        users.setStatus("ativo");
        users.setAddress("Rua A, 123");
        users.setPosition("Desenvolvedor");
        users.setCompanyId(1L);
        users.setCompanyName("TechCorp");
        users.setEntryDate(LocalDate.of(2023, 1, 15));
        users.setTerminationDate(null);
    }

    @Test
    @DisplayName("Deve retornar um usuário quando encontrado")
    void testGetUserByIdSuccess() {
        // Arrange
        when(userRepository.findById(userId)).thenReturn(Optional.of(users));

        // Act
        UserResponseDTO response = userService.getUserById(userId);

        // Assert
        assertNotNull(response);
        assertEquals(userId, response.getUserId());
        assertEquals("João Silva", response.getUsername());
        assertEquals("ativo", response.getStatus());
        assertEquals("Rua A, 123", response.getAddress());
        assertEquals("Desenvolvedor", response.getPosition());
        assertEquals(1L, response.getCompanyId());
        assertEquals("TechCorp", response.getCompanyName());
        assertEquals(LocalDate.of(2023, 1, 15), response.getEntryDate());
        assertNull(response.getTerminationDate());

        // Verify
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário não encontrado")
    void testGetUserByIdNotFound() {
        // Arrange
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(userId);
        });

        assertEquals("User not found", exception.getMessage());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    @DisplayName("Deve mapear corretamente todos os campos do Users para UserResponseDTO")
    void testUserMappingCompleteness() {
        // Arrange
        users.setTerminationDate(LocalDate.of(2024, 12, 31));
        when(userRepository.findById(userId)).thenReturn(Optional.of(users));

        // Act
        UserResponseDTO response = userService.getUserById(userId);

        // Assert
        assertEquals(users.getUserId(), response.getUserId());
        assertEquals(users.getUsername(), response.getUsername());
        assertEquals(users.getStatus(), response.getStatus());
        assertEquals(users.getAddress(), response.getAddress());
        assertEquals(users.getPosition(), response.getPosition());
        assertEquals(users.getCompanyId(), response.getCompanyId());
        assertEquals(users.getCompanyName(), response.getCompanyName());
        assertEquals(users.getEntryDate(), response.getEntryDate());
        assertEquals(users.getTerminationDate(), response.getTerminationDate());
    }

    @Test
    @DisplayName("Deve chamar o repositório apenas uma vez")
    void testRepositoryShouldBeCalledOnce() {
        // Arrange
        when(userRepository.findById(userId)).thenReturn(Optional.of(users));

        // Act
        userService.getUserById(userId);

        // Assert
        verify(userRepository, times(1)).findById(userId);
        verifyNoMoreInteractions(userRepository);
    }
}

