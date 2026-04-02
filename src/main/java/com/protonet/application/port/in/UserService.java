package com.protonet.application.port.in;

import com.protonet.domain.model.service.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUserById(Long userId);
}
