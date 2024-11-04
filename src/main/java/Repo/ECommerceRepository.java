package Repo;

import java.util.List;

public interface ECommerceRepository <T>{
    void add(T entity);
    List<T> getAll();
}
