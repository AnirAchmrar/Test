package com.example.springpetclinic.services;

import java.util.Set;
//Create, Read, Update and Delete
public interface CrudService<T,ID> {

    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
