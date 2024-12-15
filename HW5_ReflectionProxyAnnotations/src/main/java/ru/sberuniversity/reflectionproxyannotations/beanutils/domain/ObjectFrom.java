package ru.sberuniversity.reflectionproxyannotations.beanutils.domain;

public class ObjectFrom {
    public String cities;
    public String street;
    public int houseNumber;
    public int apartmentNumber;
    public String sender;

    public ObjectFrom(String cities, String street, int house, int apartmentNumber, String sender) {
        this.cities = cities;
        this.street = street;
        this.houseNumber = house;
        this.apartmentNumber = apartmentNumber;
        this.sender = sender;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
