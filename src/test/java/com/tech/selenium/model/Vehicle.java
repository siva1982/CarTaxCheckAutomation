package com.tech.selenium.model;

/**
 * Created by Siva Challa on 04/08/21.
 */
public class Vehicle {

    private String registration;
    private String make;
    private String model;
    private String color;
    private String year;

    public String getRegistration() {
        return registration;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public String getColor(){
        return color;
    }

    public String getYear(){
        return year;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setMake(String make) { this.make = make; }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "registration='" + registration + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
