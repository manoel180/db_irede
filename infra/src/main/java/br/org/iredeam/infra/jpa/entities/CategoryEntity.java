package br.org.iredeam.infra.jpa.entities;


import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.infra.jpa.common.BusinessObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "categories")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends BusinessObject<CategoryEntity, Category> {


    @Column(nullable = false, name = "name", length = 100)
    private String name;


    @Override
    public CategoryEntity from(Category obj) {

        return CategoryEntity.builder()
                .entityId(obj.getEntityId())
                .name(obj.getName())
                .build();
    }

    @Override
    public Category toDomain(CategoryEntity jpaEntity) {
        return new Category(jpaEntity.entityId, jpaEntity.getCreation(), jpaEntity.isActive(), jpaEntity.getName());
    }


}
