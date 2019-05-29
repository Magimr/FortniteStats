package com.example.fortnitestats.upcomingitems;

import java.util.List;

public class UpcomingItem {

    public int rows;
    public String vbucks;
    public List<Items> items;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
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
