package com.example.dm2.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    private EditText txt1,txt2,txt3,txt4;
    private Spinner spinner1;
    private CheckBox chk1,chk2,chk3,chk4;
    private String conocimientos="";
    private RadioButton radio1;
    private String sexo="";
    private String provincia="";
    private TextView lblcandidatos;
    private int intentos=0;
    private int candidatos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        lblcandidatos = (TextView) findViewById(R.id.lblcandidatos);
        lblcandidatos.setText(lblcandidatos.getText().toString()+" "+candidatos);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        chk4 = (CheckBox) findViewById(R.id.chk4);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);
        txt2.setText(Math.round(1+Math.random()*101)+"");
        txt3 = (EditText) findViewById(R.id.txt3);
        txt3.setText(Math.round(1+Math.random()*101)+"");
        txt4 = (EditText) findViewById(R.id.txt4);
        spinner1 = (Spinner) findViewById(R.id.spiner1);
        String [] datos = new String[] {"Alava","Bizkaia","Guipuzkoa"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
    }
    public void evaluar (View v)
    {
        if (spinner1.getSelectedItem().equals("Alava"))
        {
            provincia="Alava";
        }
        if (spinner1.getSelectedItem().equals("Bizkaia"))
        {
            provincia="Bizkaia";
        }
        if (spinner1.getSelectedItem().equals("Guipuzkoa"))
        {
            provincia="Guipuzkoa";
        }
        if (radio1.isChecked())
        {
            sexo="Masculino";
        }
        else
        {
            sexo="Femenino";
        }
        if (chk1.isChecked())
        {
            conocimientos+="PHP ";
        }
        if (chk2.isChecked())
        {
            conocimientos+="JAVA ";
        }
        if (chk3.isChecked())
        {
            conocimientos+="HTML ";
        }
        if (chk4.isChecked())
        {
            conocimientos+="CSS ";
        }
        if (txt1.getText().toString().isEmpty())
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Nombre necesario", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            if (txt4.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Resultado necesario", Toast.LENGTH_LONG);
                toast.show();
            }
            else
            {
                String resultado = ((Integer.parseInt(txt2.getText().toString()))+(Integer.parseInt(txt3.getText().toString())))+"";
                if (resultado.equals(txt4.getText().toString()))
                {
                    Intent intent = new Intent(Actividad1.this, Actividad1b.class);
                    intent.putExtra("provincia",provincia);
                    intent.putExtra("conocimientos",conocimientos);
                    intent.putExtra("sexo",sexo);
                    intent.putExtra("nombre",txt1.getText().toString());
                    startActivityForResult(intent, 1234);
                }
                else
                {
                    if (intentos<2)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "Resultado Incorrecto", Toast.LENGTH_LONG);
                        toast.show();
                        intentos++;
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "Numero de intentos superado", Toast.LENGTH_LONG);
                        toast.show();
                        finish();
                    }
                }

            }
        }

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234&&resultCode==RESULT_OK)
        {
            candidatos++;
            lblcandidatos.setText("Candidatos: "+candidatos);
            sexo="";
            provincia="";
            conocimientos="";
            intentos=0;
            txt1.setText("");
            txt2.setText(Math.round(1+Math.random()*101)+"");
            txt3.setText(Math.round(1+Math.random()*101)+"");
            txt4.setText("");
        }
        else
        {
            lblcandidatos.setText("Candidatos: "+candidatos);
            sexo="";
            provincia="";
            conocimientos="";
            intentos=0;
            txt1.setText("");
            txt2.setText(Math.round(1+Math.random()*101)+"");
            txt3.setText(Math.round(1+Math.random()*101)+"");
            txt4.setText("");
        }
    }
}
   /* int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }*/