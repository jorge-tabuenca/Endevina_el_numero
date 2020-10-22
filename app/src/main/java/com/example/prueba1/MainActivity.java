package com.example.prueba1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static int intentos = 1;
    static String nombre = "";
    static int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton = findViewById(R.id.button);
        final Random rand = new Random();
        final int num = rand.nextInt(20);
        final Button boton2 = findViewById(R.id.button2);
        final Chronometer counter = (Chronometer)findViewById(R.id.timer);

        counter.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                time++;
            }
        });counter.start();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et1 = findViewById(R.id.editTextNumber);
                int numIntroduced = Integer.parseInt(et1.getText().toString());

                if(num == numIntroduced){

                    //Creamos el Dialog

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                    alert.setTitle("NOMBRE");
                    alert.setMessage("Introduce tu nombre");

                    final EditText input = new EditText(MainActivity.this);
                    alert.setView(input);

                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            nombre = input.getText().toString();

                            Intent second = new Intent(MainActivity.this, MainActivity2.class);
                            second.putExtra("nombre", nombre);
                            second.putExtra("intentos", intentos);
                            second.putExtra("tiempo", time);
                            counter.stop();
                            intentos = 1;
                            time = 0;
                            startActivity(second);

                        }
                    });

                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent second = new Intent(MainActivity.this, MainActivity.class);
                            counter.stop();
                            intentos = 1;
                            time = 0;
                            startActivity(second);

                        }
                    });
                    alert.show();
                }
                if(num < numIntroduced){
                    Toast text = Toast.makeText(MainActivity.this, "EL NUMERO ES MAS PEQUEÑO, llevas " + intentos + " intentos", Toast.LENGTH_SHORT);
                    text.show();
                    intentos ++;
                }
                if(num > numIntroduced){
                    Toast text = Toast.makeText(MainActivity.this, "EL NUMERO ES MAS GRANDE, llevas " + intentos + " intentos", Toast.LENGTH_SHORT);
                    text.show();
                    intentos ++;
                }
            }

        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(second);

            }
        });
    }
}