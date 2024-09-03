package br.org.iredeam.infra.jpa.common;

public interface ConverterEntity<E, O> {
    
    <S extends E> E from(O obj) ;

    <S extends O> O toDomain(E jpaEntity);

}
