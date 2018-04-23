package com.example.a16033760.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView star;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects){
        super(context, resource, objects);

        food = objects;

        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvFoodName = (TextView) rowView.findViewById(R.id.textViewFoodName);
        // Get the ImageView object
        star = (ImageView) rowView.findViewById(R.id.imageViewStar);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Food currentFood = food.get(position);
        // Set the TextView to show the food

        tvFoodName.setText(currentFood.getName());
        // Set the image to star    or nostar accordingly
        if(currentFood.isStar()) {
            star.setImageResource(R.drawable.star);
        }
        else {
            star.setImageResource(R.drawable.nostar);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }

}
