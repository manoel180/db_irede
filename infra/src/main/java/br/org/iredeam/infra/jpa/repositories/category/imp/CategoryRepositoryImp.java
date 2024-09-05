package br.org.iredeam.infra.jpa.repositories.category.imp;


import br.org.iredeam.data.repositories.ICategoryRepository;
import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.infra.jpa.common.JpaCrudRepository;
import br.org.iredeam.infra.jpa.entities.CategoryEntity;
import br.org.iredeam.infra.jpa.repositories.category.ICategoryJpaRepository;

public class CategoryRepositoryImp extends JpaCrudRepository<CategoryEntity, Category> implements ICategoryRepository {

    private final ICategoryJpaRepository categoryJpaRepository;
    private final CategoryEntity categoryEntity;

   public CategoryRepositoryImp(ICategoryJpaRepository categoryJpaRepository, CategoryEntity categoryEntity) {
	super(categoryJpaRepository, categoryEntity);
	this.categoryJpaRepository = categoryJpaRepository;
    this.categoryEntity = categoryEntity;
   }

}
