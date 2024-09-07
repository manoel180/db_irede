package br.org.iredeam.domain.usecases.product.image;

public interface ICreateImage<T, R> {
    T execute(R imageRequest);
}
