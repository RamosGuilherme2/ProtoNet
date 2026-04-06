package com.protonet.infrastructure.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.protonet.application.port.in.UserService;
import com.protonet.domain.model.service.dto.UserRequestDTO;
import com.protonet.domain.model.service.dto.UserResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserController - Testes unitários")
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private UserResponseDTO userResponseDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();

        userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(1L);
        userResponseDTO.setUsername("João Silva");
        userResponseDTO.setStatus("ativo");
        userResponseDTO.setAddress("Rua A, 123");
        userResponseDTO.setPosition("Desenvolvedor");
        userResponseDTO.setCompanyId(1L);
        userResponseDTO.setCompanyName("TechCorp");
        userResponseDTO.setEntryDate(LocalDate.of(2023, 1, 15));
        userResponseDTO.setTerminationDate(null);
    }

    @Test
    @DisplayName("Deve retornar 200 OK com dados do usuário")
    void testGetUserSuccess() throws Exception {
        // Arrange
        UserRequestDTO request = new UserRequestDTO();
        request.setUserId(1L);

        when(userService.getUserById(1L)).thenReturn(userResponseDTO);

        // Act & Assert
        mockMvc.perform(post("/api/find-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1L))
                .andExpect(jsonPath("$.username").value("João Silva"))
                .andExpect(jsonPath("$.status").value("ativo"))
                .andExpect(jsonPath("$.address").value("Rua A, 123"))
                .andExpect(jsonPath("$.position").value("Desenvolvedor"))
                .andExpect(jsonPath("$.companyId").value(1L))
                .andExpect(jsonPath("$.companyName").value("TechCorp"))
                .andExpect(jsonPath("$.entryDate").exists());

        verify(userService, times(1)).getUserById(1L);
    }

    // ...existing code...

    @Test
    @DisplayName("Deve chamar userService com userId correto")
    void testControllerCallsServiceWithCorrectUserId() throws Exception {
        // Arrange
        UserRequestDTO request = new UserRequestDTO();
        request.setUserId(123L);

        when(userService.getUserById(123L)).thenReturn(userResponseDTO);

        // Act
        mockMvc.perform(post("/api/find-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        // Assert
        verify(userService).getUserById(123L);
        verifyNoMoreInteractions(userService);
    }

    @Test
    @DisplayName("Deve mapear corretamente a resposta DTO para JSON")
    void testResponseDTOMappingToJson() throws Exception {
        // Arrange
        UserRequestDTO request = new UserRequestDTO();
        request.setUserId(1L);

        when(userService.getUserById(1L)).thenReturn(userResponseDTO);

        // Act & Assert
        mockMvc.perform(post("/api/find-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.username").exists())
                .andExpect(jsonPath("$.status").exists());
    }

    @Test
    @DisplayName("Deve aceitar POST request no endpoint correto")
    void testEndpointPath() throws Exception {
        // Arrange
        UserRequestDTO request = new UserRequestDTO();
        request.setUserId(1L);

        when(userService.getUserById(anyLong())).thenReturn(userResponseDTO);

        // Act & Assert
        mockMvc.perform(post("/api/find-user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}

