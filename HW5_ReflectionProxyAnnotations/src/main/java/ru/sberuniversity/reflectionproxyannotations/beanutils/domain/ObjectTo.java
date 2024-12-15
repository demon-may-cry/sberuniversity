package ru.sberuniversity.reflectionproxyannotations.beanutils.domain;

public class ObjectTo {
    public String cities;
    public String street;
    public int houseNumber;
    public int apartmentNumber;
    public String recipient;

    public ObjectTo(String cities, String street, int house, int apartmentNumber, String recipient) {
        this.cities = cities;
        this.street = street;
        this.houseNumber = house;
        this.apartmentNumber = apartmentNumber;
        this.recipient = recipient;
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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
