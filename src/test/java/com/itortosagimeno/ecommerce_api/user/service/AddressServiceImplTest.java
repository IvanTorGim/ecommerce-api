package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.AddressNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.AddressEntity;
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
    void getAddressesByUserId() throws UserNotFoundException {
        var expected = addressResponseList();
        var mock = addressEntityList();
        when(userRepository.existsById(anyInt())).thenReturn(true);
        when(addressRepository.findAllByUserId(anyInt())).thenReturn(mock);
        var actual = addressService.getAddressesByUserId(anyInt());
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
        var expected = addressResponse();
        var mock = addressEntity();
        when(addressRepository.save(any(AddressEntity.class))).thenReturn(mock);
        var request = addressRequest();
        var actual = addressService.insertAddress(request);
        assertEquals(expected, actual);
        verify(addressRepository).save(any(AddressEntity.class));
    }

    @Test
    void updateAddress() throws AddressNotFoundException {
        var expected = addressResponse();
        var mock = addressEntity();
        var find = addressEntityOptional();
        when(addressRepository.findById(anyInt())).thenReturn(find);
        when(addressRepository.save(any(AddressEntity.class))).thenReturn(mock);
        var request = addressRequest();
        var actual = addressService.updateAddress(anyInt(), request);
        assertEquals(expected, actual);
        verify(addressRepository).findById(anyInt());
        verify(addressRepository).save(any(AddressEntity.class));
    }

    @Test
    void updateAddressThrowsAddressNotFoundException() {
        when(addressRepository.findById(anyInt())).thenReturn(Optional.empty());
        var request = addressRequest();
        assertThrows(AddressNotFoundException.class, () -> addressService.updateAddress(anyInt(), request));
        verify(addressRepository).findById(anyInt());
        verify(addressRepository, times(0)).save(any(AddressEntity.class));
    }

    @Test
    void deleteAddress() throws AddressNotFoundException {
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