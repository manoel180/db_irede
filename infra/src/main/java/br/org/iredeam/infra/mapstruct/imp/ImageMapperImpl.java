package br.org.iredeam.infra.mapstruct.imp;

import br.org.iredeam.data.dtos.CategoryDto;
import br.org.iredeam.data.dtos.ImageDto;
import br.org.iredeam.data.mappers.ICategoryMapper;
import br.org.iredeam.data.mappers.IImageMapper;
import br.org.iredeam.data.requests.CategoryRequest;
import br.org.iredeam.data.requests.ImageRequest;
import br.org.iredeam.domain.entities.Category;
import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.infra.mapstruct.ICategoryMapStruct;
import br.org.iredeam.infra.mapstruct.IImageMapStruct;

import java.util.List;


public record ImageMapperImpl(IImageMapStruct imageMapStruct) implements IImageMapper {

    @Override
    public ImageDto imageToImageDto(Image image) {
        return imageMapStruct.map(image);
    }

    @Override
    public Image imageFormToImage(ImageRequest imageRequest) {
        return imageMapStruct.map(imageRequest);
    }

    @Override
    public List<ImageDto> imageToListImageDto(List<Image> images) {
        return imageMapStruct.map(images);
    }
}
