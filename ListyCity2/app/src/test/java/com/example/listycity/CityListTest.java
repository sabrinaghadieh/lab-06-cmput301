package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCityTrue() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "BC");
        cityList.add(city);

        // should return 1 since Vancouver, BC is in mockCityList at index 1
        assertEquals(1, cityList.hasCity(city));

    }

    @Test
    public void testHasCityFalse() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "BC");

        // should return -1 since Vancouver, BC was not added to cityList
        assertEquals(-1, cityList.hasCity(city));

    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);

        int before = cityList.countCities();

        cityList.deleteCity(city);

        // size should decrease by 1
        assertEquals(before - 1, cityList.countCities());

        // city should no longer be found
        assertEquals(-1, cityList.hasCity(city));
    }

    @Test
    public void testDeleteCityException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");

        // should throw exception since it is not in the list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();

        // Edmonton, Alberta already in list
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Toronto", "Ontario");
        City city3 = new City("Vancouver", "BC");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        // should return 4
        assertEquals(4, cityList.countCities());
    }
}
