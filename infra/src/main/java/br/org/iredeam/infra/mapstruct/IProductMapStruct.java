package br.org.iredeam.infra.mapstruct;

import br.org.iredeam.data.dtos.ProductDto;
import br.org.iredeam.data.requests.ProductRequest;
import br.org.iredeam.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface IProductMapStruct {


    @Mapping(target = "createdAt", source = "creation", dateFormat = "dd/MM/yyyy' 'HH:mm:ss")
    @Mapping(target = "category.createdAt", source = "category.creation", dateFormat = "dd/MM/yyyy' 'HH:mm:ss")
    ProductDto map(Product product);

    List<ProductDto> map(List<Product> productsList);


    @Mapping(target = "entityId", ignore = true)
    @Mapping(target = "creation", ignore = true)
    @Mapping(target = "active", ignore = true)
    Product map(ProductRequest productRequest);

}
