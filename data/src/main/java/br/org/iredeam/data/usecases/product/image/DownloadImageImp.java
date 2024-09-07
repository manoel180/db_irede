package br.org.iredeam.data.usecases.product.image;

import br.org.iredeam.data.repositories.IImageRepository;
import br.org.iredeam.domain.entities.Image;
import br.org.iredeam.domain.usecases.product.image.IDownloadImage;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;


public class DownloadImageImp implements IDownloadImage {
    private final IImageRepository imageRepository;


    public DownloadImageImp(IImageRepository imageRepository) {

        this.imageRepository = imageRepository;
    }

    @Override
    public byte[] execute(Long id) {
        Optional<Image> dbImage = imageRepository.findById(id);
        return dbImage.map(Image::getImage).orElse(null);
    }
}