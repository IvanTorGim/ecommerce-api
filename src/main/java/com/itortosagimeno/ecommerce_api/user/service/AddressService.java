package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.user.model.dto.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.dto.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddressesByUserId(Integer userId);

    AddressResponse insertAddress(AddressRequest addressRequest);

    AddressResponse updateAddress(Integer id, AddressRequest addressRequest);

    void deleteAddress(Integer id);
}