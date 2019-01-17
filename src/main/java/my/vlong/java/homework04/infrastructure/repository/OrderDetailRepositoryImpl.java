package my.vlong.java.homework04.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import my.vlong.java.homework04.entity.Order;
import my.vlong.java.homework04.entity.OrderDetail;
import my.vlong.java.homework04.entity.OrderDetailKey;
import my.vlong.java.homework04.entity.Product;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;
import my.vlong.java.homework04.repository.IOrderDetailRepository;

public class OrderDetailRepositoryImpl implements IOrderDetailRepository {

    private EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public OrderDetailRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("StorePU");
    }

    @Override
    public Optional<OrderDetail> add(OrderDetail t) throws CreatedException {
        if (t == null) {
            throw new CreatedException("Can not created order detail");
        }
        System.out.println(t);
        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("BREAKXXXXX: " + e.getMessage());
            throw new CreatedException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<OrderDetail> update(OrderDetail t) throws UpdatedException {
        if (t == null) {
            throw new UpdatedException("Can not updated product");
        }

        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new UpdatedException(e.getMessage());
        } finally {

        }
    }

    @Override
    public boolean delete(OrderDetailKey id) throws DeletedException {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            OrderDetail orderDetail = entityManager.find(OrderDetail.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(orderDetail);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DeletedException(e.getMessage());
        } finally {

        }
        return true;
    }

    @Override
    public Optional<OrderDetail> findByOne(OrderDetailKey k) throws DataNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        OrderDetail orderDetail = null;
        try {
            orderDetail = entityManager.find(OrderDetail.class, k);
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {

        }
        return Optional.ofNullable(orderDetail);
    }

    @Override
    public List<OrderDetail> findAll() throws DataNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        List<OrderDetail> orders = new ArrayList<>();

        try {
            CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
            criteriaQuery.select(criteriaQuery.from(OrderDetail.class));
            Query query = entityManager.createQuery(criteriaQuery);
            orders = query.getResultList();
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {

        }

        return orders;
    }

    @Override
    public List<OrderDetail> getOrderDetail(Order order) throws DataNotFoundException {
        if (order == null) {
            throw new DataNotFoundException("Data not found");
        }
        entityManager = entityManagerFactory.createEntityManager();
        List<OrderDetail> orderDetails = new ArrayList<>();

        try {
            TypedQuery<OrderDetail> query = entityManager.createQuery("SELECT od FROM order_detail WHERE order_id = :order_id", OrderDetail.class);
            query.setParameter("order_id", order.getId());
            orderDetails = query.getResultList();
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {

        }

        return orderDetails;
    }

}
