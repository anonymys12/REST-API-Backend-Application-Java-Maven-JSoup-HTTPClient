package com.example.autoria.model;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String price;
    private String region;
    private String link;

    public Car(String brand, String model, int year, String price, String region, String link) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.region = region;
        this.link = link;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getPrice() { return price; }
    public String getRegion() { return region; }
    public String getLink() { return link; }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ") - " + price + " - " + region + " - " + link;
    }
}
