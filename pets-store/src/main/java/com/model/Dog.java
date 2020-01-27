package com.model;
//POJO - Plain Old Java Object
public class Dog {
    private String name;
    private int age;
    private String color;
    private Meal anything;

    public Meal getAnything() {
        return anything;
    }

    public void setAnything(Meal anything) {
        this.anything = anything;
    }

    public void cry(){
        System.out.println("@)@(@*@*@&hmmmmmmmmmm@^@^@^@");
    }
    public Dog(){
        System.out.println("Dog barks at night!!!");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", anything=" + anything +
                '}';
    }
}
