package my.vlong.java.homework04.infrastructure;

import java.util.List;
import java.util.Optional;
import my.vlong.java.homework04.entity.OrderDetail;
import my.vlong.java.homework04.entity.OrderDetailKey;
import my.vlong.java.homework04.repository.IOrderDetailRepository;

public class OrderDetailRepositoryImpl implements IOrderDetailRepository {

    @Override
    public Optional<OrderDetail> save(OrderDetail t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(OrderDetail t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<OrderDetail> findByOne(OrderDetailKey k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetail> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
