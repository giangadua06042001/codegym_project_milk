package model;

import java.util.Date;

public class Product {
    private int p_id;
    private String p_name;
    private String p_price;
    private String p_weight;
    private String unit;
    private String right_alway;

    public Product( String p_name, String p_price, String p_weight, String unit,String right_alway) {
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_weight = p_weight;
        this.unit = unit;
        this.right_alway=right_alway;
    }

    public Product(String p_name, String p_price, String p_weight, String unit) {
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_weight = p_weight;
        this.unit = unit;
    }

    public Product(int p_id, String p_name, String p_price, String p_weight, String unit, String right_alway) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_weight = p_weight;
        this.unit = unit;
        this.right_alway = right_alway;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_weight() {
        return p_weight;
    }

    public void setP_weight(String p_weight) {
        this.p_weight = p_weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRight_alway() {
        return right_alway;
    }

    public void setRight_alway(String right_alway) {
        this.right_alway = right_alway;
    }

    @Override
    public String toString() {
        return "Product{" +
                "p_id='" + p_id + '\'' +
                ", name='" + p_name + '\'' +
                ", price='" + p_price + '\'' +
                ", weight='" + p_weight + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
