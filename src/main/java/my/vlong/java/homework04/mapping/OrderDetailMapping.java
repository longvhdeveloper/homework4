package my.vlong.java.homework04.mapping;

import my.vlong.java.homework04.dto.OrderDetailDTO;
import my.vlong.java.homework04.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailMapping extends IMapping<OrderDetail, OrderDetailDTO> {

    OrderDetailMapping INSTANCE = Mappers.getMapper(OrderDetailMapping.class);
}
