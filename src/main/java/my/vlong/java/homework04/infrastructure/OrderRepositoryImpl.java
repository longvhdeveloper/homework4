package my.vlong.java.homework04.infrastructure;

import java.util.List;
import java.util.Optional;
import my.vlong.java.homework04.entity.Order;
import my.vlong.java.homework04.repository.IOrderRepository;

public class OrderRepositoryImpl implements IOrderRepository {

    @Override
    public Optional<Order> save(Order t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Order t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Order> findByOne(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
