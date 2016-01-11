package com.student.matthew.opstoppingmetmaps.model;

/**
 * Created by Matthew on 9-1-2016.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable
public class Plaatsen {

@DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String pininfo;

    @DatabaseField
    private double pinLat;

    @DatabaseField
    private double pinLng;

    @DatabaseField
    private Date begintijd;

    @DatabaseField
    private Date eindtijd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPininfo() {
        return pininfo;
    }

    public void setPininfo(String pininfo) {
        this.pininfo = pininfo;
    }

    public double getPinLat() {
        return pinLat;
    }

    public void setPinLat(double pinLat) {
        this.pinLat = pinLat;
    }

    public double getPinLng() {
        return pinLng;
    }

    public void setPinLng(double pinLng) {
        this.pinLng = pinLng;
    }

    public Date getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(Date begintijd) {
        this.begintijd = begintijd;
    }

    public Date getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(Date eindtijd) {
        this.eindtijd = eindtijd;
    }

    public Plaatsen(int id, String pininfo, double pinLat, double pinLng, Date begintijd, Date eindtijd) {
        this.id = id;
        this.pininfo = pininfo;
        this.pinLat = pinLat;
        this.pinLng = pinLng;
        this.begintijd = begintijd;
        this.eindtijd = eindtijd;
    }

    public Plaatsen() {
    }
}
