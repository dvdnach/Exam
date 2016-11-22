package com.example.dm2.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad1b extends AppCompatActivity {

    TextView lblnombre2,lblsexo2,lblprovincia2,lblconocimientos2;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1b);
        extras = getIntent().getExtras();
        lblnombre2 = (TextView) findViewById(R.id.lblnombre2);
        lblnombre2.setText(lblnombre2.getText().toString()+" "+extras.getString("nombre"));
        lblsexo2 = (TextView) findViewById(R.id.lblsexo2);
        lblsexo2.setText(lblsexo2.getText().toString()+" "+extras.getString("sexo"));
        lblprovincia2 = (TextView) findViewById(R.id.lblprovincia2);
        lblprovincia2.setText(lblprovincia2.getText().toString()+" "+extras.getString("provincia"));
        lblconocimientos2 = (TextView) findViewById(R.id.lblconocimientos2);
        lblconocimientos2.setText(lblconocimientos2.getText().toString()+" "+extras.getString("conocimientos"));
    }
    public void aceptar (View v)
    {
        Intent intent = new Intent();
        intent.putExtra("resultado","aceptar");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void rechazar (View v)
    {
        Intent intent = new Intent();
        intent.putExtra("resultado","rechazar");
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}
