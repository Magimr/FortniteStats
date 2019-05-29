package com.example.fortnitestats.shop;

import java.util.List;

public class Shop {

    private String date_layout;
    private long lastupdate;
    private String language;
    private String date;
    private long rows;
    private String vbucks;
    private List<Items> items;

    public String getDate_layout() {
        return date_layout;
    }

    public void setDate_layout(String date_layout) {
        this.date_layout = date_layout;
    }

    public long getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(long lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getRows() {
        return rows;
    }

    public void setRows(long rows) {
        this.rows = rows;
    }

    public String getVbucks() {
        return vbucks;
    }

    public void setVbucks(String vbucks) {
        this.vbucks = vbucks;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
