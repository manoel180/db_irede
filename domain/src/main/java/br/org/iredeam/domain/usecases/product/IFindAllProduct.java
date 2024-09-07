package br.org.iredeam.domain.usecases.product;

import java.util.List;

public interface IFindAllProduct<T> {
    List<T> execute();
}
