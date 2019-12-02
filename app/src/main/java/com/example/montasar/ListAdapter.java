package com.example.montasar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class ListAdapter extends ArrayAdapter<Voyage>{


    private ArrayList<Voyage> dataSet;
    Context context;
    SQLiteDatabase database;
    public ListAdapter(@NonNull Context context, ArrayList<Voyage> objects)
    {
        super(context, R.layout.travel_item, objects);
        this.context = context;
        database = MainActivity.connect.getWritableDatabase();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.travel_item, parent, false);
        byte[] img = getItem(position).getImage();
        String designation = getItem(position).getDesignation();
        final int id = getItem(position).getId();
        ImageView imageView = convertView.findViewById(R.id.photo);
        TextView textView = convertView.findViewById(R.id.designation);
        //Button delete = convertView.findViewById(R.id.btnDelete);
        /*delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.remove(getItem(position));
                Connect.deleteDestination(database, id);
                notifyDataSetChanged();
            }
        });*/
        textView.setText(designation);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.length));

        return convertView;
    }
}
