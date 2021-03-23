package ru.smal.dao;

import java.util.List;

public interface Dao <Entity, Key>{
    List<Entity> findByAll();
    Entity findById();
    void add();
    void update();
    void delete();
}
