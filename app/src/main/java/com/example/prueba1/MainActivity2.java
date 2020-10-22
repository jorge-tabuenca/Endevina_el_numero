package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    static ArrayList<personas>list = new ArrayList<personas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button boton = findViewById(R.id.button3);

        if(savedInstanceState == null){
            Bundle b = getIntent().getExtras();
            if(b != null){

                nuevaPersona();

            }
        }

        if(!list.isEmpty()){

            imprimirTabla(list);

        }

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent principal = new Intent(MainActivity2.this, MainActivity.class);;
                startActivity(principal);

            }
        });
    }

    private void nuevaPersona() {
        String nombreIntent = getIntent().getExtras().getString("nombre");
        String intentosIntent = Integer.toString(getIntent().getIntExtra("intentos", -1));
        String tiempoIntent = Integer.toString(getIntent().getIntExtra("tiempo", -1));

        personas p = new personas(nombreIntent, intentosIntent, tiempoIntent);
        list.add(p);
    }

    private void imprimirTabla(ArrayList<personas> list) {

        final TableLayout tbl=(TableLayout) findViewById(R.id.tableLayaout);

        for(personas p : list){

            TableRow row=new TableRow(this);
            TextView nombre=new TextView(this);
            TextView intentos=new TextView(this);
            TextView tiempo=new TextView(this);

            TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT,1.0f);
            TableRow.LayoutParams params2=new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.FILL_PARENT);

            nombre.setText(p.getName());
            intentos.setText(p.getTrys());
            tiempo.setText(p.getTime());

            nombre.setLayoutParams(params1);
            intentos.setLayoutParams(params1);
            tiempo.setLayoutParams(params1);

            row.addView(nombre);
            row.addView(intentos);
            row.addView(tiempo);

            row.setLayoutParams(params2);
            tbl.addView(row);

        }
    }
}