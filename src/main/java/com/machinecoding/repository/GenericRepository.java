package com.machinecoding.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenericRepository<T, ID> {
    private final Map<ID, T> entities = new HashMap<>();

    public void add(ID id, T entity) {
        entities.put(id, entity);
    }

    public T get(ID id) {
        return entities.get(id);
    }

    public Collection<T> getAll() {
        return entities.values();
    }
}