package br.org.iredeam.data.usecases.product;


import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.mappers.IProductMapper;
import br.org.iredeam.data.repositories.IProductRepository;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.domain.usecases.product.ICreateProduct;

public class CreateProductImpl implements ICreateProduct<ProductDto, ProductRequest> {

    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    public CreateProductImpl(IProductRepository productRepository, IProductMapper productMapper) {

        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto execute(ProductRequest productRequest) {
        Product product = productMapper.productFormToProduct(productRequest);
        return productMapper.productToProductDto(this.productRepository.save(product));
    }
}
