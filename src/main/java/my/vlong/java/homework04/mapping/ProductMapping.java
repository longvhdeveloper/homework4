package my.vlong.java.homework04.mapping;

import my.vlong.java.homework04.dto.ProductDTO;
import my.vlong.java.homework04.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapping extends IMapping<Product, ProductDTO> {

    ProductMapping INSTANCE = Mappers.getMapper(ProductMapping.class);
}
