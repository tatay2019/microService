package com.example.montasar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ConsultItem extends AppCompatActivity {

    TextView txtDes, txtCont, txtSuper;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_item);
        init();
        Voyage voyage = (Voyage) getIntent().getSerializableExtra("voyageDetails");
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(voyage.getImage(), 0, voyage.getImage().length));
        txtDes.setText(voyage.getDesignation());
        txtCont.setText(voyage.getContinant());
        txtSuper.setText(""+voyage.getSuperficie());


    }

    public void init() {
        txtDes = findViewById(R.id.txtDesignationConsult);
        txtCont = findViewById(R.id.txtContinantConsult);
        txtSuper = findViewById(R.id.txtSuperficieConsult);
        imageView = findViewById(R.id.photoConsult);
    }
}
