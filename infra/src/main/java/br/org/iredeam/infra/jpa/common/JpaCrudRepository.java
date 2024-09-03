package br.org.iredeam.infra.jpa.common;

import br.org.iredeam.domain.common.BusinessObjectDomain;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public abstract class JpaCrudRepository<E extends BusinessObject<E, O>, O extends BusinessObjectDomain>
	 {

    private final CRUDGenericRepository<E, O> jpa;
    private final E entity;

    protected JpaCrudRepository(CRUDGenericRepository<E, O> jpa, E entity) {
        this.jpa = jpa;
        this.entity = entity;
    }

    public O save(O obj) {
	E e = this.jpa.save(entity.from(obj));
	return entity.toDomain(e);
    }
    public Optional<O> findById(Long id) {
	Optional<E> jpaEntity = jpa.findById(id);
	return jpaEntity.map(entity::toDomain);
    }
    public List<O> findAll() {
	List<E> list = this.jpa.findAll();
	return list.stream().map(entity::toDomain).toList();
    }

    public void delete(O obj) {
	this.jpa.save(entity.from(obj));
    }

}
