package com.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentRecord")
public class Student {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    @Column(name = "address")
    private String city;

    private int marks;

    private long mobino;

    public Student() {}

    public Student(String name, int rollNo, String city, int marks, long mobino) {
        super();
        this.name = name;
        this.rollNo = rollNo;
        this.city = city;
        this.marks = marks;
        this.mobino = mobino;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public long getMobino() {
        return mobino;
    }

    public void setMobino(long mobino) {
        this.mobino = mobino;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", city=" + city + ", marks=" + marks + ", mobino="
                + mobino + "]";
    }
}
