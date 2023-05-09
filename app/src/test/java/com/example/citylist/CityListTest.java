package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a class that tests the CityList class
 */
public class CityListTest {
    /**
     * @return This returns a mock city list
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * @return This returns a mock city
     */
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * This tests that the add method works
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }


    /**
     * This tests that the delete method works
     */
    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        int initialSize = cityList.getCities(1).size();
        assertEquals(initialSize, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(initialSize+1, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));

        cityList.delete(city);
        assertEquals(initialSize, cityList.getCities(1).size());
        assertFalse(cityList.getCities(1).contains(city));
    }


    /**
     * This tests that the delete method throws an exception when deleting a city that does not exist
     */
    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "SK");
        assertFalse(cityList.getCities(1).contains(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }


    /**
     * This tests that the add method throws an exception when adding a city that already exists
     */
    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * This tests that the getCities method works
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());
        assertEquals(1, cityList.getCities(2).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertEquals(2, cityList.getCities(2).size());
        assertTrue(cityList.getCities(1).contains(city));
        assertTrue(cityList.getCities(2).contains(city));

        City city2 = new City("AAA", "ZZZ");
        cityList.add(city2);
        assertEquals(city2, cityList.getCities(1).get(0));
        assertEquals(city2, cityList.getCities(2).get(cityList.count()-1));
    }

    /**
     * This tests that the count method works
     */
    @Test
    public void testCount() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.count());

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(2, cityList.count());
    }
}
