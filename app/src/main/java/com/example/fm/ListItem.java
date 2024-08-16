package com.example.fm;
public class ListItem {

    private String name;
    private String cost;
    private String mincost;
    private String fee;

    private int Img;
    private String name0;
    private String order;

    public String getName() { return name; }
    public void setName(String name) {this.name = name; }

    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }

    public String getMincost() { return mincost; }
    public void setMincost(String mincost) { this.mincost = mincost; }

    public String getFee() { return fee; }
    public void setFee(String fee) { this.fee = fee; }

    public String getName0() { return name0; }
    public int getImg() { return Img; }
    public String getOrder() { return order; }

    ListItem(String name, String cost, String mincost, String fee){
        this.name = name;
        this.cost = cost;
        this.mincost = mincost;
        this.fee = fee;
    }

    ListItem(String name0, int Img, String order) {
        this.name0 = name0;
        this.Img = Img;
        this.order = order;
    }
}