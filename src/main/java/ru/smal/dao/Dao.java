package ru.smal.dao;

import java.util.List;

public interface Dao <Entity, Key>{
    List<Entity> findByAll();
    Entity findById(Entity entity);
    void add(Entity entity);
    void update(Entity entity);
    void delete(Entity entity);
}
