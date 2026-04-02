package com.protonet.infrastructure.adapter;

import com.protonet.domain.model.service.dto.UserRequestDTO;
import com.protonet.domain.model.service.dto.UserResponseDTO;
import com.protonet.application.port.in.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/find-user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> getUser(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = userService.getUserById(request.getUserId());
        return ResponseEntity.ok(response);
    }
}


