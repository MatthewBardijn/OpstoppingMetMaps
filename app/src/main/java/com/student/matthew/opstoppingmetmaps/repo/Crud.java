package com.student.matthew.opstoppingmetmaps.repo;

/**
 * Created by Matthew on 9-1-2016.
 */
import java.util.List;

interface Crud
{
    public int create(Object item);
    public int update(Object item);
    public int delete(Object item);
    public Object findById(int id);
    public List<?> findAll();
}