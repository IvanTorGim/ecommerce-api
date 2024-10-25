package com.itortosagimeno.ecommerce_api.product.model;

public record ProductResponseDTO(
        Integer id,
        String name,
        String description,
        Double price,
        Category category,
        String image,
        Integer stock
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

        public ProductResponseDTO build() {
            return new ProductResponseDTO(id, name, description, price, category, image, stock);
        }
    }
}
