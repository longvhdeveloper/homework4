package my.vlong.java.homework04.infrastructure;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import my.vlong.java.homework04.entity.Product;
import my.vlong.java.homework04.repository.IProductRepository;

public class ProductRepositoryImpl implements IProductRepository {
    
    private EntityManager entityManager;
    
    public ProductRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StorePU");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Override
    public Optional<Product> save(Product t) {
        if (t == null) {
            return Optional.empty();
        }
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        
        return Optional.of(t);
    }
    
    @Override
    public boolean delete(Product t) {
        if (t == null) {
            return false;
        }
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
        return true;
    }
    
    @Override
    public Optional<Product> findByOne(Integer k) {
        Product product = entityManager.find(Product.class, k);
        return Optional.ofNullable(product);
    }
    
    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
