package com.sandro.finder.domain;

public class Agency {

    private Number number;
    private String address;
    private String oppeningHours;

    public Agency(Number number, String address, String oppeningHours) {
        this.number = number;
        this.address = address;
        this.oppeningHours = oppeningHours;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOppeningHours() {
        return oppeningHours;
    }

    public void setOppeningHours(String oppeningHours) {
        this.oppeningHours = oppeningHours;
    }
}
