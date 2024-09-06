package br.org.iredeam.data.usecases.product;


import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.mappers.IProductMapper;
import br.org.iredeam.data.repositories.IProductRepository;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.domain.usecases.product.IUpdateProduct;
import br.org.iredeam.utils.MergeUtil;

import java.util.Optional;

public class UpdateProductImpl implements IUpdateProduct<ProductDto, ProductRequest> {

    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    public UpdateProductImpl(IProductRepository productRepository, IProductMapper productMapper) {

        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto execute(Long id, ProductRequest productRequest) throws IllegalAccessException, InstantiationException {
        Optional<Product> productEntity = productRepository.findById(id);

        if (productEntity.isPresent()) {
            Product product = productMapper.productFormToProduct(productRequest);
            product = MergeUtil.merge(product, productEntity.get());
            return productMapper.productToProductDto(this.productRepository.save(product));
        }
        return null;
    }
}
