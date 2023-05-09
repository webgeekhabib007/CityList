package com.example.citylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    /**
     * @param context This is the context
     * @param cities This is the list of cities
     */
    public CustomList(Context context, ArrayList<City> cities){
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    /**
     * @param position This is the position of the city
     * @param convertView This is the view
     * @param parent This is the parent view
     * @return This returns the view
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;
    }
}
