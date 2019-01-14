package my.vlong.java.homework04.mapping;

import my.vlong.java.homework04.dto.OrderDTO;
import my.vlong.java.homework04.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapping extends IMapping<Order, OrderDTO> {

    OrderMapping INSTANCE = Mappers.getMapper(OrderMapping.class);
}
