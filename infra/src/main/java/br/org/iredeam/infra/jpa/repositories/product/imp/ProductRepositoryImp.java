package br.org.iredeam.infra.jpa.repositories.product.imp;


import br.org.iredeam.data.repositories.IProductRepository;
import br.org.iredeam.data.repositories.ISearchProductRepository;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.infra.jpa.common.JpaCrudRepository;
import br.org.iredeam.infra.jpa.entities.ProductEntity;
import br.org.iredeam.infra.jpa.repositories.product.IProductJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImp extends JpaCrudRepository<ProductEntity, Product> implements IProductRepository, ISearchProductRepository {

    private final IProductJpaRepository productJpaRepository;
    private final ProductEntity productEntity;

    public ProductRepositoryImp(IProductJpaRepository productJpaRepository, ProductEntity productEntity) {
        super(productJpaRepository, productEntity);
        this.productJpaRepository = productJpaRepository;
        this.productEntity = productEntity;
    }

    @Override
    public List<Product> search(String searchTerm, Integer page, Integer size) {

        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");

        List<Product> products = new ArrayList<>();
        List<ProductEntity> productEntities = productJpaRepository.search(searchTerm, pageRequest).getContent();
        productEntities.forEach(productEntity -> products.add(productEntity.toDomain(productEntity)));
        return products;
    }
}
