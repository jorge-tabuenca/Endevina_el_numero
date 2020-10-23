package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    static ArrayList<personas>list = new ArrayList<personas>();
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recycler = findViewById(R.id.recyclerId);
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setLayoutManager(new GridLayoutManager(this, 1));

        if(savedInstanceState == null){
            Bundle b = getIntent().getExtras();
            if(b != null){

                nuevaPersona();

            }
        }

        if(!list.isEmpty()){

            MyAdapter adapter = new MyAdapter(list);
            recycler.setAdapter(adapter);

        }

        final Button boton = findViewById(R.id.button3);

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
}