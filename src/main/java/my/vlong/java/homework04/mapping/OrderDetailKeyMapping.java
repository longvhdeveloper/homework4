package my.vlong.java.homework04.mapping;

import my.vlong.java.homework04.dto.OrderDetailKeyDTO;
import my.vlong.java.homework04.entity.OrderDetailKey;
import org.mapstruct.Mapper;

@Mapper
public interface OrderDetailKeyMapping extends IMapping<OrderDetailKey, OrderDetailKeyDTO> {

}
