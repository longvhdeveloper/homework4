package my.vlong.java.homework04.mapping;

import my.vlong.java.homework04.dto.OrderDetailDTO;
import my.vlong.java.homework04.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapping extends IMapping<OrderDetail, OrderDetailDTO> {

    OrderDetailMapping INSTANCE = Mappers.getMapper(OrderDetailMapping.class);

    @Override
    @Mappings({
        @Mapping(target = "product", expression = "java(my.vlong.java.homework04.mapping.ProductMapping.INSTANCE.toEntity(dto.getProduct()))"),
        @Mapping(target = "order", expression = "java(my.vlong.java.homework04.mapping.OrderMapping.INSTANCE.toEntity(dto.getOrder()))")
    })
    public OrderDetail toEntity(OrderDetailDTO dto);
}
