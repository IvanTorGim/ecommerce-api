package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.custom.AddressNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserNotAuthorizedException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.dto.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.AddressResponse;
import com.itortosagimeno.ecommerce_api.user.model.mapper.AddressMapper;
import com.itortosagimeno.ecommerce_api.user.repository.AddressRepository;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AddressResponse> getAddressesByUserId(final Integer userId) {
        final var exists = userRepository.existsById(userId);
        if (!exists) throw new UserNotFoundException(userId);
        return addressRepository.findAllByUserId(userId)
                .stream()
                .map(AddressMapper::toResponse)
                .toList();
    }

    @Override
    public AddressResponse insertAddress(final AddressRequest addressRequest) {
        final var entity = AddressMapper.toEntity(addressRequest);
        final var saved = addressRepository.save(entity);
        return AddressMapper.toResponse(saved);
    }

    @Override
    public AddressResponse updateAddress(final Integer id, final AddressRequest addressRequest) {
        final var found = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));
        var matchRequestUserIdAndFoundUserId = found.getUser().getId().equals(addressRequest.userId());
        if (!matchRequestUserIdAndFoundUserId) throw new UserNotAuthorizedException();
        final var entity = AddressMapper.toEntity(addressRequest, found);
        final var updated = addressRepository.save(entity);
        return AddressMapper.toResponse(updated);
    }

    @Override
    public void deleteAddress(final Integer id) {
        final var exists = addressRepository.existsById(id);
        if (!exists) throw new AddressNotFoundException(id);
        addressRepository.deleteById(id);
    }
}