package br.org.iredeam.data.commons;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<T, L> {
    T save(T entity);

    Optional<T> findById(L id);

    List<T> findAll();

    void delete(T entity);
}
