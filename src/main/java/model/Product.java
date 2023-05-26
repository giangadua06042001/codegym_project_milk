package model;

import java.util.Date;

public class Product {
    private String p_id;
    private String name;
    private String price;
    private String weight;
    private String unit;
    private Date right_away;

    public Product(String p_id, String name, String price, String weight, String unit, Date right_away) {
        this.p_id = p_id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.unit = unit;
        this.right_away = right_away;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getRight_away() {
        return right_away;
    }

    public void setRight_away(Date right_away) {
        this.right_away = right_away;
    }
}
