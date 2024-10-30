package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.custom.AddressNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserNotAuthorizedException;
import com.itortosagimeno.ecommerce_api.exception.custom.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.entity.AddressEntity;
import com.itortosagimeno.ecommerce_api.user.repository.AddressRepository;
import com.itortosagimeno.ecommerce_api.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.itortosagimeno.ecommerce_api.user.service.AddressServiceDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Test
    void getAddressesByUserId() {
        final var expected = addressResponseList();
        final var mock = addressEntityList();
        when(userRepository.existsById(anyInt())).thenReturn(true);
        when(addressRepository.findAllByUserId(anyInt())).thenReturn(mock);
        final var actual = addressService.getAddressesByUserId(anyInt());
        assertEquals(expected, actual);
        verify(userRepository).existsById(anyInt());
        verify(addressRepository).findAllByUserId(anyInt());
    }

    @Test
    void getAddressesByUserIdThrowsUserNotFoundException() {
        when(userRepository.existsById(anyInt())).thenReturn(false);
        assertThrows(UserNotFoundException.class, () -> addressService.getAddressesByUserId(anyInt()));
        verify(userRepository).existsById(anyInt());
        verify(addressRepository, times(0)).findAllByUserId(anyInt());
    }

    @Test
    void insertAddress() {
        final var expected = addressResponse();
        final var mock = addressEntity();
        when(addressRepository.save(any(AddressEntity.class))).thenReturn(mock);
        final var request = addressRequest();
        final var actual = addressService.insertAddress(request);
        assertEquals(expected, actual);
        verify(addressRepository).save(any(AddressEntity.class));
    }

    @Test
    void updateAddress() {
        final var expected = addressResponse();
        final var mock = addressEntity();
        final var optional = optionalAddressEntity();
        when(addressRepository.findById(anyInt())).thenReturn(optional);
        when(addressRepository.save(any(AddressEntity.class))).thenReturn(mock);
        final var request = addressRequest();
        final var actual = addressService.updateAddress(anyInt(), request);
        assertEquals(expected, actual);
        verify(addressRepository).findById(anyInt());
        verify(addressRepository).save(any(AddressEntity.class));
    }

    @Test
    void updateAddressThrowsAddressNotFoundException() {
        when(addressRepository.findById(anyInt())).thenReturn(Optional.empty());
        final var request = addressRequest();
        assertThrows(AddressNotFoundException.class, () -> addressService.updateAddress(anyInt(), request));
        verify(addressRepository).findById(anyInt());
        verify(addressRepository, times(0)).save(any(AddressEntity.class));
    }

    @Test
    void updateAddressThrowsUserNotAuthorizedException() {
        final var optional = optionalAddressEntityWithNoValidUserId();
        when(addressRepository.findById(anyInt())).thenReturn(optional);
        final var request = addressRequest();
        assertThrows(UserNotAuthorizedException.class, () -> addressService.updateAddress(anyInt(), request));
        verify(addressRepository).findById(anyInt());
        verify(addressRepository, times(0)).save(any(AddressEntity.class));
    }

    @Test
    void deleteAddress() {
        when(addressRepository.existsById(anyInt())).thenReturn(true);
        addressService.deleteAddress(anyInt());
        verify(addressRepository).existsById(anyInt());
        verify(addressRepository).deleteById(anyInt());
    }

    @Test
    void deleteAddressThrowsAddressNotFoundException() {
        when(addressRepository.existsById(anyInt())).thenReturn(false);
        assertThrows(AddressNotFoundException.class, () -> addressService.deleteAddress(anyInt()));
        verify(addressRepository).existsById(anyInt());
        verify(addressRepository, times(0)).deleteById(anyInt());
    }
}