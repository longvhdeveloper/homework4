package my.vlong.java.homework04.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import my.vlong.java.homework04.entity.Order;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;
import my.vlong.java.homework04.repository.IOrderRepository;

public class OrderRepositoryImpl implements IOrderRepository {

    private EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public OrderRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("StorePU");
    }

    @Override
    public Optional<Order> add(Order t) throws CreatedException {
        if (t == null) {
            throw new CreatedException("Can not created order");
        }

        entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new CreatedException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<Order> update(Order t) throws UpdatedException {
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
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean delete(Integer id) throws DeletedException {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            Order order = entityManager.find(Order.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(order);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DeletedException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return true;
    }

    @Override
    public Optional<Order> findByOne(Integer k) throws DataNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        Order order = null;
        try {
            order = entityManager.find(Order.class, k);
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return Optional.ofNullable(order);
    }

    @Override
    public List<Order> findAll() throws DataNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders = new ArrayList<>();

        try {
            CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
            criteriaQuery.select(criteriaQuery.from(Order.class));
            Query query = entityManager.createQuery(criteriaQuery);
            orders = query.getResultList();
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return orders;
    }

}
