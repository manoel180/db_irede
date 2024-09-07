package br.org.iredeam.infra.jpa.repositories.product.image;


import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.infra.jpa.common.CRUDGenericRepository;
import br.org.iredeam.infra.jpa.entities.ImageEntity;

public interface IImageJpaRepository extends CRUDGenericRepository<ImageEntity, Image> {

}
