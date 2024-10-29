package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.exception.AddressNotFoundException;
import com.itortosagimeno.ecommerce_api.exception.UserNotFoundException;
import com.itortosagimeno.ecommerce_api.user.model.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddressesByUserId(Integer userId) throws UserNotFoundException;

    AddressResponse insertAddress(AddressRequest addressRequest);

    AddressResponse updateAddress(Integer id, AddressRequest addressRequest) throws AddressNotFoundException;

    void deleteAddress(Integer id) throws AddressNotFoundException;
}