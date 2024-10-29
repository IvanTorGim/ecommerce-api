package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.UserMapper;
import com.itortosagimeno.ecommerce_api.user.model.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.UserResponse;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(final Integer id) throws UserNotFoundException {
        final var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) throw new UserNotFoundException(id);
        return UserMapper.toResponse(userOptional.get());
    }

    @Override
    public UserResponse updateUser(final Integer id, final UserRequest userRequest) throws UserNotFoundException {
        final var entityOptional = userRepository.findById(id);
        if (entityOptional.isEmpty()) throw new UserNotFoundException(id);
        final var user = UserMapper.toEntity(userRequest, entityOptional.get(), passwordEncoder);
        final var userUpdated = userRepository.save(user);
        return UserMapper.toResponse(userUpdated);
    }

    @Override
    public void deleteUser(final Integer id) throws UserNotFoundException {
        final var exists = userRepository.existsById(id);
        if (!exists) throw new UserNotFoundException(id);
        userRepository.deleteById(id);
    }
}
