package br.org.iredeam.infra.mapstruct.imp;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.mappers.IProductMapper;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.infra.mapstruct.IProductMapStruct;

import java.util.List;


public record ProductMapperImpl(IProductMapStruct productMapStruct) implements IProductMapper {

    @Override
    public ProductDto productToProductDto(Product product) {
        return productMapStruct.map(product);
    }

    @Override
    public Product productFormToProduct(ProductRequest productRequest) {
        return productMapStruct.map(productRequest);
    }

    @Override
    public List<ProductDto> productToListProductsDto(List<Product> products) {
        return productMapStruct.map(products);
    }
}
