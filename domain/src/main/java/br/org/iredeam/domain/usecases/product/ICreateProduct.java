package br.org.iredeam.domain.usecases.product;

public interface ICreateProduct<T, R> {
    T execute(R productRequest);
}
