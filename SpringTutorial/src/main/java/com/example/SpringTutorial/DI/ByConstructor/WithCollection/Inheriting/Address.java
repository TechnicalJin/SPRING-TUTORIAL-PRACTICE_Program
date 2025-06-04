package com.example.SpringTutorial.DI.ByConstructor.WithCollection.Inheriting;

public class Address {

    private String address, city, state, country;

    public Address() {
    }

    public Address(String address, String city, String state, String country) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
