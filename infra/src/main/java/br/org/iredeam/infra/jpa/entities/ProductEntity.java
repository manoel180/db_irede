package br.org.iredeam.infra.jpa.entities;


import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.infra.jpa.common.BusinessObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "products")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BusinessObject<ProductEntity, Product> {


    @Column(nullable = false, name = "name", length = 50)
    private String name;
    @Column(name = "description", length = 200)
    private String description;
    @Column(nullable = false, name = "price")
    private BigDecimal price;
    @Column(nullable = false, name = "expirationDate")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "categoryId")
    private CategoryEntity category;


    @Override
    public ProductEntity from(Product obj) {

        return ProductEntity.builder()
                .entityId(obj.getEntityId())
                .name(obj.getName())
                .description(obj.getDescription())
                .price(obj.getPrice())
                .expirationDate(obj.getExpirationDate())
                .category(obj.getCategory() != null ? new CategoryEntity().from(obj.getCategory()) : null)
                .build();
    }

    @Override
    public Product toDomain(ProductEntity jpaEntity) {
        return new Product(jpaEntity.entityId,
                jpaEntity.getCreation(),
                jpaEntity.isActive(),
                jpaEntity.getName(),
                jpaEntity.getDescription(),
                jpaEntity.getPrice(),
                jpaEntity.getExpirationDate(),
                jpaEntity.getCategory() != null ? jpaEntity.getCategory().toDomain(jpaEntity.getCategory()) : null
        );
    }


}
