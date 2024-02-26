package com.techelevator.hotels.model;

public class IpCountry {

    private String ip;
    private String country;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "IpCountry{" +
                "ip='" + ip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
