package br.org.iredeam.data.mappers;


import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Product;

import java.util.List;

public interface IProductMapper {
    ProductDto productToProductDto(Product product);

    Product productFormToProduct(ProductRequest productRequest);

    List<ProductDto> productToListProductsDto(List<Product> products);
}
