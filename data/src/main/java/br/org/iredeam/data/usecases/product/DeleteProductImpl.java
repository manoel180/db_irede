package br.org.iredeam.data.usecases.product;


import br.org.iredeam.data.repositories.IProductRepository;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.domain.usecases.product.IDeleteProduct;

import java.util.Optional;

public class DeleteProductImpl implements IDeleteProduct {

    private final IProductRepository productRepository;


    public DeleteProductImpl(IProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Boolean execute(Long id) {
        Boolean deleted = Boolean.FALSE;
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            this.productRepository.delete(product.get());
            deleted = Boolean.TRUE;
        }
        return deleted;
    }
}
