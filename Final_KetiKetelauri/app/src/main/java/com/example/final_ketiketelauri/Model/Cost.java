package com.example.final_ketiketelauri.Model;

public class Cost {
    int id;
    String costTime;
    int costcost;
    String costAbout;

    public Cost() {
    }

    public Cost(int id, String costTime, int costcost, String costAbout) {
        this.id = id;
        this.costTime = costTime;
        this.costcost = costcost;
        this.costAbout = costAbout;
    }
    public Cost( String costTime, int costcost, String costAbout) {
        this.costTime = costTime;
        this.costcost = costcost;
        this.costAbout = costAbout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public int getCostcost() {
        return costcost;
    }

    public void setCostcost(int costcost) {
        this.costcost = costcost;
    }

    public String getCostAbout() {
        return costAbout;
    }

    public void setCostAbout(String costAbout) {
        this.costAbout = costAbout;
    }
}
