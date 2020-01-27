package com.model;

public class Meal {
    private int milk;
    private String meat;

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "milk=" + milk +
                ", meat='" + meat + '\'' +
                '}';
    }
}
