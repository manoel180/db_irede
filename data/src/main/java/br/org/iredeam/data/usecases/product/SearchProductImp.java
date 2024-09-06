package br.org.iredeam.data.usecases.product;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.mappers.IProductMapper;
import br.org.iredeam.data.repositories.ISearchProductRepository;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.domain.usecases.product.ISearchProduct;

import java.util.List;


public class SearchProductImp implements ISearchProduct<ProductDto> {
    private final ISearchProductRepository productRepository;
    private final IProductMapper productMapper;

    public SearchProductImp(ISearchProductRepository productRepository, IProductMapper productMapper) {

        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> execute(Integer page, Integer size, String searchTerm) {
        List<Product> products = productRepository.search(searchTerm, page, size);
        return productMapper.productToListProductsDto(products);
    }
}