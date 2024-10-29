package com.itortosagimeno.ecommerce_api.user.model;

public class AddressMapper {

    public static AddressEntity toEntity(AddressRequest request) {
        final var user = UserEntity.builder()
                .id(request.userId())
                .build();
        return AddressEntity.builder()
                .user(user)
                .street(request.street())
                .city(request.city())
                .country(request.country())
                .zipCode(request.zipCode())
                .build();
    }

    public static AddressEntity toEntity(AddressRequest request, AddressEntity entity) {
        entity.setStreet(request.street());
        entity.setCity(request.city());
        entity.setCountry(request.country());
        entity.setZipCode(request.zipCode());
        return entity;
    }

    public static AddressResponse toResponse(AddressEntity entity) {
        return AddressResponse.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .street(entity.getStreet())
                .city(entity.getCity())
                .country(entity.getCountry())
                .zipCode(entity.getZipCode())
                .build();
    }
}