package br.org.iredeam.data.repositories;

import br.org.iredeam.data.commons.IGenericRepository;
import br.org.iredeam.domain.entities.Product;

import java.util.List;

public interface ISearchProductRepository extends IGenericRepository<Product, Long> {
    List<Product> search(String searchTerm, Integer page, Integer size);
}
