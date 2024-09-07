package br.org.iredeam.infra.mapstruct;

import br.org.iredeam.data.dtos.ImageDto;
import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.requests.ImageRequest;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface IImageMapStruct {


    @Mapping(target = "createdAt", source = "creation", dateFormat = "dd/MM/yyyy' 'HH:mm:ss")
    ImageDto map(Image image);

    List<ImageDto> map(List<Image> imageList);

    @Mapping(target = "entityId", ignore = true)
    @Mapping(target = "creation", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "product.entityId", source = "product")
    Image map(ImageRequest imageRequest);


}
