package com.example.restapi;

public class AnimalClass {
    int ID;
    String KIND;
    double WEIGHT,HEIGHT;
    String SEX;
    int AGE;

    public AnimalClass(int ID, String KIND, double WEIGHT, double HEIGHT, String SEX, int AGE) {
        this.ID = ID;
        this.KIND = KIND;
        this.WEIGHT = WEIGHT;
        this.HEIGHT = HEIGHT;
        this.SEX = SEX;
        this.AGE = AGE;
    }
}
