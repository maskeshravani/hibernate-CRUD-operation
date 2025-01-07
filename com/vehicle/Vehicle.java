package com.vehicle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicleRecord")
public class Vehicle {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    private String color;
        
    @Column(name= "CName")
    private String comName;

    public Vehicle() { }

    public Vehicle(String name, int id, int price, String color, String comName) {
        super();
        this.name = name;
        this.id = id;
        this.price = price;
        this.color = color;
        this.comName = comName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
    
    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", name=" + name + ", price=" + price + 
               ", color=" + color + ", comName=" + comName + "]";
    }

}
