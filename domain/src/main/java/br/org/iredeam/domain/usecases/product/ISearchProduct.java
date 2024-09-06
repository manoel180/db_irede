package br.org.iredeam.domain.usecases.product;

import java.util.List;

public interface ISearchProduct<T> {
    List<T> execute(Integer page, Integer size, String searchTerm);
}
