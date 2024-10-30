package com.itortosagimeno.ecommerce_api.user.service;

import com.itortosagimeno.ecommerce_api.user.model.AddressEntity;
import com.itortosagimeno.ecommerce_api.user.model.AddressRequest;
import com.itortosagimeno.ecommerce_api.user.model.AddressResponse;
import com.itortosagimeno.ecommerce_api.user.model.UserEntity;

import java.util.List;
import java.util.Optional;

public class AddressServiceDataProvider {

    protected static List<AddressResponse> addressResponseList() {
        return List.of(
                new AddressResponse(
                        1,
                        1,
                        "street 1",
                        "city 1",
                        "country 1",
                        "11111"
                ),
                new AddressResponse(
                        2,
                        1,
                        "street 2",
                        "city 2",
                        "country 2",
                        "22222"
                )
        );
    }

    protected static List<AddressEntity> addressEntityList() {
        var user = new UserEntity();
        user.setId(1);
        return List.of(
                new AddressEntity(
                        1,
                        "street 1",
                        "city 1",
                        "country 1",
                        "11111",
                        user
                ),
                new AddressEntity(
                        2,
                        "street 2",
                        "city 2",
                        "country 2",
                        "22222",
                        user
                )
        );
    }

    protected static AddressResponse addressResponse() {
        return new AddressResponse(
                1,
                1,
                "street 1",
                "city 1",
                "country 1",
                "11111"
        );
    }

    protected static AddressRequest addressRequest() {
        return new AddressRequest(
                1,
                "street 1",
                "city 1",
                "country 1",
                "11111"
        );
    }

    protected static AddressEntity addressEntity() {
        var user = new UserEntity(1);
        return new AddressEntity(
                1,
                "street 1",
                "city 1",
                "country 1",
                "11111",
                user
        );
    }

    protected static Optional<AddressEntity> optionalAddressEntity() {
        var user = new UserEntity(1);
        return Optional.of(new AddressEntity(
                1,
                "street 2",
                "city 2",
                "country 2",
                "22222",
                user
        ));
    }

    protected static Optional<AddressEntity> optionalAddressEntityWithNoValidUserId() {
        var user = new UserEntity(2);
        return Optional.of(new AddressEntity(
                1,
                "street 2",
                "city 2",
                "country 2",
                "22222",
                user
        ));
    }
}