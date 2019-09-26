package dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> extends Serializable {

    T save(T entity);

    T update(T entity);

    List<T> listAll();

    void remove(T entity);

    T findById(Serializable id);
}
