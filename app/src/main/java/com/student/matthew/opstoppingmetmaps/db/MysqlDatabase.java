package com.student.matthew.opstoppingmetmaps.db;

import android.os.AsyncTask;

import com.student.matthew.opstoppingmetmaps.model.Plaatsen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Matthew on 10-1-2016.
 */
public class MysqlDatabase {
    private static final String url = "jdcb:mysql:dt5.ehb.be/JEE011";
    private static final String user = "JEE011";
    private static final String pass = "39527841";


    public ArrayList<Plaatsen> getall(){

        ArrayList<Plaatsen> pls = new ArrayList<Plaatsen>();
        Plaatsen pl;
        int id;
        String pinInfo;
        double pinLat,pinLng;
        Date beginTijd,eindTijd;

            try{
                Class.forName("com.mysql.jdcb.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);

                Statement st = con.createStatement();
                String sql = "select * from Plaatsen";

                final ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    id = rs.getInt("id");
                    pinInfo = rs.getString("pinInfo");
                    pinLat = rs.getDouble("pinLat");
                    pinLng = rs.getDouble("pinLng");
                    beginTijd = rs.getDate("beginTijd");
                    eindTijd = rs.getDate("eindTijd");
                   pl = new Plaatsen(id,pinInfo,pinLat,pinLng,beginTijd,eindTijd);
                    pls.add(pl);
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
return pls;
    }

}
