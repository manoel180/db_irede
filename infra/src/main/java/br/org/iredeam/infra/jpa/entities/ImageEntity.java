package br.org.iredeam.infra.jpa.entities;


import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.infra.jpa.common.BusinessObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@Getter
@Setter
@Entity
@Table(name = "images",
        uniqueConstraints = { @UniqueConstraint(name = "UKImage", columnNames = { "productId", "name" }) })
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity extends BusinessObject<ImageEntity, Image> {


    @Column(nullable = false, name = "name", length = 100)
    private String name;

    @Lob
    @Column(name="image")
    @JdbcTypeCode(Types.LONGVARBINARY)
    private byte[] image;

    @ManyToOne
    @JoinColumn(nullable = false, name = "productId")
    private ProductEntity product;

    @Override
    public ImageEntity from(Image obj) {

        return ImageEntity.builder()
                .entityId(obj.getEntityId())
                .name(obj.getName())
                .image(obj.getImage())
                .product(new ProductEntity().from(obj.getProduct()))
                .build();
    }

    @Override
    public Image toDomain(ImageEntity jpaEntity) {
        return new Image(jpaEntity.entityId, jpaEntity.getCreation(),
                jpaEntity.isActive(), jpaEntity.getProduct().toDomain(jpaEntity.getProduct()), jpaEntity.getName(), jpaEntity.getImage());
    }


}
