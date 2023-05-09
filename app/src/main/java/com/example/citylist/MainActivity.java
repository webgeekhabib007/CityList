package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the main activity of the app
 */
public class MainActivity extends AppCompatActivity {

    // Declare the variables so that you will be able to reference it later.
    ListView cityList;
    ArrayAdapter<City> cityAdapter;
    ArrayList<City> cityDataList;

    /**
     * @param savedInstanceState This is the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);

        String cities[] = {"Edmonton", "Vancouver", "Toronto", "Calgary", "Hamilton", "Waterloo" };
        String provinces[] = {"AB", "BC", "ON", "AB", "ON", "ON"};

        cityDataList = new ArrayList<>();

        for(int i=0; i<cities.length; i++){
            cityDataList.add(new City(cities[i], provinces[i]));
        }

        cityAdapter = new CustomList(this, cityDataList);

        cityList.setAdapter(cityAdapter);
    }
}