package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }


    /**
     * This returns the index of a specified city if it exists in the list, -1 otherwise
     * @param city
     * This is a candidate city to check if its in the list
     * @return
     * Returns the index of the city if it is in the list, -1 otherwise
     */
    public int hasCity(City city) {

      // Reference: https://www.w3schools.com/java/java_arraylist.asp
        // iterate through each city in the list and check if indicated city is present
        for (int i = 0; i < countCities(); i++) {
            if (cities.get(i).equals(city)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This deletes the city from the list if it exists
     * @param city
     * This is a candidate city to delete
     */
    public void deleteCity(City city) {
        int index = hasCity(city);
        if (index == -1) {
            throw new IllegalArgumentException();
        } else {
            cities.remove(index);
        }
    }

    /**
     * This returns how many cities are in the list
     * @return
     * Return the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
