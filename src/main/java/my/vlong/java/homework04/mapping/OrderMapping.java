package my.vlong.java.homework04.mapping;

import my.vlong.java.homework04.dto.OrderDTO;
import my.vlong.java.homework04.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = DateMapping.class)
public interface OrderMapping extends IMapping<Order, OrderDTO> {

    OrderMapping INSTANCE = Mappers.getMapper(OrderMapping.class);

    @Override
    @Mappings({
        @Mapping(target = "status", expression = "java(my.vlong.java.homework04.entity.Status.map(entity.getStatus()))")
    })
    public OrderDTO toDTO(Order entity);

    @Override
    @Mappings({
        @Mapping(target = "status", expression = "java(dto.getStatus().getCode())")
    })
    public Order toEntity(OrderDTO dto);
}
