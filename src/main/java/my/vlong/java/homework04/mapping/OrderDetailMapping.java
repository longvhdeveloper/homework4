package my.vlong.java.homework04.mapping;

import java.util.List;
import my.vlong.java.homework04.dto.OrderDetailDTO;
import my.vlong.java.homework04.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapping.class)
public interface OrderDetailMapping extends IMapping<OrderDetail, OrderDetailDTO> {

    OrderDetailMapping INSTANCE = Mappers.getMapper(OrderDetailMapping.class);

    @Override
    public List<OrderDetailDTO> toDTOs(List<OrderDetail> entities);

    @Override
    public List<OrderDetail> toEntities(List<OrderDetailDTO> dtos);

    @Override
    @Mappings({
        @Mapping(target = "productDTO", source = "entity.product"),
        @Mapping(target = "orderDTO", source = "entity.order"),
        @Mapping(target = "orderDTO.status", expression = "java(my.vlong.java.homework04.entity.Status.map(order.getStatus()))")
    })
    public OrderDetailDTO toDTO(OrderDetail entity);

    @Override
    @Mappings({
        @Mapping(target = "product", source = "dto.productDTO"),
        @Mapping(target = "order", source = "dto.orderDTO"),
        @Mapping(target = "order.status", expression = "java(orderDTO.getStatus().getCode())")
    })
    public OrderDetail toEntity(OrderDetailDTO dto);

}
