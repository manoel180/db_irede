package br.org.iredeam.infra.jpa.repositories.product.image.imp;


import br.org.iredeam.data.repositories.IImageRepository;
import br.org.iredeam.data.repositories.IProductRepository;
import br.org.iredeam.data.repositories.ISearchImageRepository;
import br.org.iredeam.data.repositories.ISearchProductRepository;
import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.domain.entities.Product;
import br.org.iredeam.infra.jpa.common.JpaCrudRepository;
import br.org.iredeam.infra.jpa.entities.ImageEntity;
import br.org.iredeam.infra.jpa.entities.ProductEntity;
import br.org.iredeam.infra.jpa.repositories.product.IProductJpaRepository;
import br.org.iredeam.infra.jpa.repositories.product.image.IImageJpaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class ImageRepositoryImp extends JpaCrudRepository<ImageEntity, Image> implements IImageRepository {

    private final IImageJpaRepository imageJpaRepository;
    private final ImageEntity imageEntity;

    public ImageRepositoryImp(IImageJpaRepository imageJpaRepository, ImageEntity imageEntity) {
        super(imageJpaRepository, imageEntity);
        this.imageJpaRepository = imageJpaRepository;
        this.imageEntity = imageEntity;
    }


}
