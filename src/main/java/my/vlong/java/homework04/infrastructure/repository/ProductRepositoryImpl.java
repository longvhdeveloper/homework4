package my.vlong.java.homework04.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import my.vlong.java.homework04.entity.Product;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;
import my.vlong.java.homework04.repository.IProductRepository;

public class ProductRepositoryImpl implements IProductRepository {

    private EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public ProductRepositoryImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("StorePU");
    }

    @Override
    public Optional<Product> add(Product t) throws CreatedException {
        if (t == null) {
            throw new CreatedException("Can not created product");
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
    public Optional<Product> update(Product t) throws UpdatedException {
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
            Product product = entityManager.find(Product.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DeletedException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return true;
    }

    @Override
    public Optional<Product> findByOne(Integer k) throws DataNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        Product product = null;
        try {
            product = entityManager.find(Product.class, k);
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() throws DataNotFoundException {
        entityManager = entityManagerFactory.createEntityManager();
        List<Product> products = new ArrayList<>();

        try {
            CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
            criteriaQuery.select(criteriaQuery.from(Product.class));
            Query query = entityManager.createQuery(criteriaQuery);
            products = query.getResultList();
        } catch (Exception e) {
            throw new DataNotFoundException(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return products;
    }

}
