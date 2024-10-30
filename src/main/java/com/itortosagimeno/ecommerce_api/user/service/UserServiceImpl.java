package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.UserMapper;
import com.itortosagimeno.ecommerce_api.user.model.UserRequest;
import com.itortosagimeno.ecommerce_api.user.model.UserResponse;
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
    public UserResponse getUserById(final Integer id) throws UserNotFoundException {
        final var optional = userRepository.findById(id);
        if (optional.isEmpty()) throw new UserNotFoundException(id);
        return UserMapper.toResponse(optional.get());
    }

    @Override
    public UserResponse updateUser(final Integer id, final UserRequest userRequest) throws UserNotFoundException {
        final var optional = userRepository.findById(id);
        if (optional.isEmpty()) throw new UserNotFoundException(id);
        final var entity = UserMapper.toEntity(userRequest, optional.get(), passwordEncoder);
        final var updated = userRepository.save(entity);
        return UserMapper.toResponse(updated);
    }

    @Override
    public void deleteUser(final Integer id) throws UserNotFoundException {
        final var exists = userRepository.existsById(id);
        if (!exists) throw new UserNotFoundException(id);
        userRepository.deleteById(id);
    }
}
