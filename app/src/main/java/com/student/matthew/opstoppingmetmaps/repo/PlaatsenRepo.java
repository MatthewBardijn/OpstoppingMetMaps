package com.student.matthew.opstoppingmetmaps.repo;

/**
 * Created by Matthew on 9-1-2016.
 */

import android.content.Context;
import com.student.matthew.opstoppingmetmaps.db.DatabaseManager;
import com.student.matthew.opstoppingmetmaps.model.Plaatsen;
import com.student.matthew.opstoppingmetmaps.db.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

public class PlaatsenRepo implements Crud{
    private DatabaseHelper helper;

    public PlaatsenRepo(Context context){
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }
    @Override
    public int create(Object item){

        int index = -1;

        Plaatsen object = (Plaatsen) item;
        try{
            index = helper.getPlaatsenDao().create(object);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return index;
    }
    @Override
    public int update(Object item) {

        int index = -1;

        Plaatsen object = (Plaatsen) item;

        try {
            helper.getPlaatsenDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {

        int index = -1;

        Plaatsen object = (Plaatsen) item;

        try {
            helper.getPlaatsenDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;

    }

    @Override
    public Object findById(int id) {

        Plaatsen wishList = null;
        try {
            wishList = helper.getPlaatsenDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishList;

    }

    @Override
    public List<Plaatsen> findAll() {

        List<Plaatsen> items = null;

        try {
            items = helper.getPlaatsenDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
