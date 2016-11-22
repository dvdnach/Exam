package com.example.dm2.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Entrada extends AppCompatActivity {

    Button btnact1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
        btnact1 = (Button) findViewById(R.id.btnact1);
    }
    public void act1 (View v)
    {
        Intent intent = new Intent(Entrada.this, Actividad1.class);
        startActivity(intent);
    }
    public void act2 (View v)
    {
        Intent intent = new Intent(Entrada.this, Actividad2.class);
        startActivity(intent);
    }
    public void act3 (View v)
    {
        if (btnact1.getText().equals("Actividad1"))
        {
            Toast toast = Toast.makeText(getApplicationContext(),"Actividad no implementada",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(),"Activity not implemented",Toast.LENGTH_LONG);
            toast.show();
        }

    }
    public void salir (View v)
    {
        finish();
    }
}
