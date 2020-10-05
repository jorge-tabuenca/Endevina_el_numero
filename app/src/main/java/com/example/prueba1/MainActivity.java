package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int intentos = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button boton = findViewById(R.id.button);
        final Random rand = new Random();
        final int num = rand.nextInt(20);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et1 = findViewById(R.id.editTextNumber);
                int numIntroduced = Integer.parseInt(et1.getText().toString());

                if(num == numIntroduced){
                    Toast text = Toast.makeText(MainActivity.this, "CORRECTO, Te ha costado " + intentos + " intentos", Toast.LENGTH_SHORT);
                    text.show();
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
    }
}