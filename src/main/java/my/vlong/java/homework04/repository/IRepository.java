package my.vlong.java.homework04.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, K> {

    Optional<T> save(T t);

    boolean delete(T t);

    Optional<T> findByOne(K k);

    List<T> findAll();
}
