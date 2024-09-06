package br.org.iredeam.data.usecases.product;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.mappers.IProductMapper;
import br.org.iredeam.data.repositories.IProductRepository;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.domain.usecases.product.IFindAllProduct;

import java.util.List;


public class FindAllProductImp implements IFindAllProduct<ProductDto> {
    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    public FindAllProductImp(IProductRepository productRepository, IProductMapper productMapper) {

        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> execute() {
        List<Product> products = productRepository.findAll();
        return productMapper.productToListProductsDto(products);
    }
}