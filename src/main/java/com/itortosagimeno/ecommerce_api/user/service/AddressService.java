package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.user.model.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddressesByUserId(Integer userId);

    AddressResponse insertAddress(AddressRequest addressRequest);

    AddressResponse updateAddress(Integer id, AddressRequest addressRequest);

    void deleteAddress(Integer id);
}