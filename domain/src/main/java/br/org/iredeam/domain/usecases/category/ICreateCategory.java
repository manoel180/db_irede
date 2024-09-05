package br.org.iredeam.domain.usecases.category;

public interface ICreateCategory<T, R> {
    T execute(R categoryRequest);
}
