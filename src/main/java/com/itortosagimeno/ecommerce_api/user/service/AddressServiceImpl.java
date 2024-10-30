package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.AddressNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.AddressMapper;
import com.itortosagimeno.ecommerce_api.user.model.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.AddressResponse;
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
    public List<AddressResponse> getAddressesByUserId(final Integer userId) throws UserNotFoundException {
        final var exists = userRepository.existsById(userId);
        if (!exists) throw new UserNotFoundException(userId);
        return addressRepository.findAllByUserId(userId)
                .stream()
                .map(AddressMapper::toResponse)
                .toList();
    }

    @Override
    public AddressResponse insertAddress(final AddressRequest addressRequest) {
        if (addressRequest.userId() == null)
            throw new IllegalArgumentException("UserId is required for creating a new address");
        final var entity = AddressMapper.toEntity(addressRequest);
        final var saved = addressRepository.save(entity);
        return AddressMapper.toResponse(saved);
    }

    @Override
    public AddressResponse updateAddress(final Integer id, final AddressRequest addressRequest) throws AddressNotFoundException {
        final var optional = addressRepository.findById(id);
        if (optional.isEmpty()) throw new AddressNotFoundException(id);
        final var entity = AddressMapper.toEntity(addressRequest, optional.get());
        final var updated = addressRepository.save(entity);
        return AddressMapper.toResponse(updated);
    }

    @Override
    public void deleteAddress(final Integer id) throws AddressNotFoundException {
        final var exists = addressRepository.existsById(id);
        if (!exists) throw new AddressNotFoundException(id);
        addressRepository.deleteById(id);
    }
}