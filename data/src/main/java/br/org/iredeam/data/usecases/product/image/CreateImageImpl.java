package br.org.iredeam.data.usecases.product.image;


import br.org.iredeam.data.dtos.ImageDto;
import br.org.iredeam.data.mappers.IImageMapper;
import br.org.iredeam.data.repositories.IImageRepository;
import br.org.iredeam.data.requests.ImageRequest;
import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.domain.usecases.product.image.ICreateImage;

public class CreateImageImpl implements ICreateImage<ImageDto, ImageRequest> {

    private final IImageRepository imageRepository;
    private final IImageMapper imageMapper;

    public CreateImageImpl(IImageRepository imageRepository, IImageMapper imageMapper) {

        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    @Override
    public ImageDto execute(ImageRequest imageRequest) {
        Image image = imageMapper.imageFormToImage(imageRequest);
        return imageMapper.imageToImageDto(this.imageRepository.save(image));
    }
}
