package br.org.iredeam.data.mappers;

import br.org.iredeam.data.dtos.ImageDto;
import br.org.iredeam.data.requests.ImageRequest;
import br.org.iredeam.domain.entities.Image;

import java.util.List;

public interface IImageMapper {
    ImageDto imageToImageDto(Image image);

    Image imageFormToImage(ImageRequest imageRequest);

    List<ImageDto> imageToListImageDto(List<Image> images);
}
