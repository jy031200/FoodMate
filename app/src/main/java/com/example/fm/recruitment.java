package com.example.fm;

public class recruitment {

    private String category;
    private String content;
    private String menu;
    private String min_price;
    private String name;
    private String num;
    private String payment;
    private String price;
    private String purpose;
    private String request_ceo;
    private String request_rider;
    private String request_spoon;
    private String restaurant;
    private String term;
    private String title;
    private String time;

    public recruitment() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRequest_ceo() {
        return request_ceo;
    }

    public void setRequest_ceo(String request_ceo) {
        this.request_ceo = request_ceo;
    }

    public String getRequest_rider() {
        return request_rider;
    }

    public void setRequest_rider(String request_rider) {
        this.request_rider = request_rider;
    }

    public String getRequest_spoon() {
        return request_spoon;
    }

    public void setRequest_spoon(String request_spoon) {
        this.request_spoon = request_spoon;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public recruitment(String category, String content, String menu, String min_price, String name, String num, String payment, String price, String purpose, String request_ceo, String request_rider, String request_spoon, String restaurant, String term, String title, String time) {
        this.category = category;
        this.content = content;
        this.menu = menu;
        this.min_price = min_price;
        this.name = name;
        this.num = num;
        this.payment = payment;
        this.price = price;
        this.purpose = purpose;
        this.request_ceo = request_ceo;
        this.request_rider = request_rider;
        this.request_spoon = request_spoon;
        this.restaurant = restaurant;
        this.term = term;
        this.title = title;
        this.time = time;
    }
}
