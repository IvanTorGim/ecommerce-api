package com.itortosagimeno.ecommerce_api.models.dtos;

import com.itortosagimeno.ecommerce_api.models.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductDTO(
        @Null Integer id,
        @NotNull @NotBlank String name,
        @NotNull String description,
        @NotNull @PositiveOrZero Double price,
        @NotNull Category category,
        @NotNull String image,
        @NotNull @PositiveOrZero Integer stock
) {
    public static ProductDTOBuilder builder() {
        return new ProductDTOBuilder();
    }

    public static class ProductDTOBuilder {
        private Integer id;
        private String name;
        private String description;
        private Double price;
        private Category category;
        private String image;
        private Integer stock;

        public ProductDTOBuilder() {
        }

        public ProductDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ProductDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductDTOBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductDTOBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public ProductDTOBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ProductDTOBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(id, name, description, price, category, image, stock);
        }
    }
}
