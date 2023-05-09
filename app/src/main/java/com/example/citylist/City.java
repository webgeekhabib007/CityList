package com.example.citylist;

/**
 * This is a class that keeps track of a city object
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * @param city This is the city
     * @param province This is the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * @return This returns the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * @return This returns the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * @param city This is the city to compare
     * @return This returns the comparison
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}