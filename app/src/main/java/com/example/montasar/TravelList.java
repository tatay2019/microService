package com.example.montasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TravelList extends AppCompatActivity {

    ListView listView;
    ArrayList<Voyage> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_list);

        listView = findViewById(R.id.listView);

        list = new ArrayList<>();

        Cursor cursor = MainActivity.connect.getVoyage("select * from voyage");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String designation = cursor.getString(1);
            String continant = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            double superficie = cursor.getDouble(4);
            Log.d("working...", designation);
            list.add(new Voyage(id, designation, continant, image, superficie));
        }

        final ListAdapter listAdapter = new ListAdapter( TravelList.this,
                this.list);

        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Voyage destination = listAdapter.getItem(position);
                Intent intent = new Intent(TravelList.this, ConsultItem.class);
                intent.putExtra("destination", destination);
                startActivity(intent);
            }
        });

    }
}
