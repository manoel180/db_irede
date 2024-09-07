package br.org.iredeam.domain.usecases.product;

public interface IUpdateProduct<T, R> {
    T execute(Long id, R productRequest) throws IllegalAccessException, InstantiationException;
}
