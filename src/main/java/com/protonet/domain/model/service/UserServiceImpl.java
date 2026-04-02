package com.protonet.domain.model.service;

import com.protonet.domain.model.service.dto.UserResponseDTO;
import com.protonet.application.port.in.UserService;
import com.protonet.application.port.out.UserRepository;
import com.protonet.domain.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        Users users = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponseDTO response = new UserResponseDTO();
        response.setUserId(users.getUserId());
        response.setUsername(users.getUsername());
        response.setStatus(users.getStatus());
        response.setAddress(users.getAddress());
        response.setPosition(users.getPosition());
        response.setCompanyId(users.getCompanyId());
        response.setCompanyName(users.getCompanyName());
        response.setEntryDate(users.getEntryDate());
        response.setTerminationDate(users.getTerminationDate());
        return response;
    }
}
