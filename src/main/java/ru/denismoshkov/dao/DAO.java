package ru.denismoshkov.dao;

public interface DAO<T> {

    void insert(T t);

    T get(String firstParam, String secondParam) throws Exception;
}
