package com.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animalRecord")
public class Animal {

	@Id
	
	private int age;
	@Column(name = "Aname")
	private String name;
	private String color;
	private String sound;
	private String Eat;
	
	
	public Animal() {
		
	}
	public Animal(int age, String name, String color, String sound, String eat) {
		super();
		this.age = age;
		this.name = name;
		this.color = color;
		this.sound = sound;
		Eat = eat;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getEat() {
		return Eat;
	}
	public void setEat(String eat) {
		Eat = eat;
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + ", color=" + color + ", sound=" + sound + ", Eat=" + Eat + "]";
	}
	
	
}
