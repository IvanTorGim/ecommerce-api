package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.custom.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.dto.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.UserResponse;
import com.itortosagimeno.ecommerce_api.user.model.mapper.UserMapper;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(final Integer id) {
        final var optional = userRepository.findById(id);
        if (optional.isEmpty()) throw new UserNotFoundException(id);
        return UserMapper.toResponse(optional.get());
    }

    @Override
    public UserResponse updateUser(final Integer id, final UserRequest userRequest) {
        final var optional = userRepository.findById(id);
        if (optional.isEmpty()) throw new UserNotFoundException(id);
        final var entity = UserMapper.toEntity(userRequest, optional.get(), passwordEncoder);
        final var updated = userRepository.save(entity);
        return UserMapper.toResponse(updated);
    }

    @Override
    public void deleteUser(final Integer id) {
        final var exists = userRepository.existsById(id);
        if (!exists) throw new UserNotFoundException(id);
        userRepository.deleteById(id);
    }
}
