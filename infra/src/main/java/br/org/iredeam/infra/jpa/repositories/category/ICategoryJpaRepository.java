package br.org.iredeam.infra.jpa.repositories.category;


import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.infra.jpa.common.CRUDGenericRepository;
import br.org.iredeam.infra.jpa.entities.CategoryEntity;

public interface ICategoryJpaRepository extends CRUDGenericRepository<CategoryEntity, Category> {

}
