package my.vlong.java.homework04.repository;

import java.util.List;
import my.vlong.java.homework04.entity.Order;
import my.vlong.java.homework04.entity.OrderDetail;
import my.vlong.java.homework04.entity.OrderDetailKey;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;

public interface IOrderDetailRepository extends IRepository<OrderDetail, OrderDetailKey> {

    List<OrderDetail> getOrderDetail(Order order) throws DataNotFoundException;
    
}
