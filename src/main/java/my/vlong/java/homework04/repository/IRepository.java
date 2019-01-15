package my.vlong.java.homework04.repository;

import java.util.List;
import java.util.Optional;
import my.vlong.java.homework04.exception.CreatedException;
import my.vlong.java.homework04.exception.DataNotFoundException;
import my.vlong.java.homework04.exception.DeletedException;
import my.vlong.java.homework04.exception.UpdatedException;

public interface IRepository<T, K> {

    Optional<T> add(T t) throws CreatedException;
    
    Optional<T> update(T t) throws UpdatedException;

    boolean delete(K k) throws DeletedException;

    Optional<T> findByOne(K k) throws DataNotFoundException;

    List<T> findAll() throws DataNotFoundException;
}
