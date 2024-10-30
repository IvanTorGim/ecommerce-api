package com.itortosagimeno.ecommerce_api.user.model;

public class AddressMapper {

    public static AddressEntity toEntity(AddressRequest request) {
        final var user = new UserEntity(request.userId());
        return new AddressEntity(
                request.street(),
                request.city(),
                request.country(),
                request.zipCode(),
                user
        );
    }

    public static AddressEntity toEntity(AddressRequest request, AddressEntity entity) {
        entity.setStreet(request.street());
        entity.setCity(request.city());
        entity.setCountry(request.country());
        entity.setZipCode(request.zipCode());
        return entity;
    }

    public static AddressResponse toResponse(AddressEntity entity) {
        return new AddressResponse(
                entity.getId(),
                entity.getUser().getId(),
                entity.getStreet(),
                entity.getCity(),
                entity.getCountry(),
                entity.getZipCode()
        );
    }
}