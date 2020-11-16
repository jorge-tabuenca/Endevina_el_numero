package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity{

    static ArrayList<personas>list = new ArrayList<personas>();
    private final int REQUEST_TAKE_PHOTO = 1;
    private RecyclerView recycler;
    private Uri mAbsolutePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recycler = findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new GridLayoutManager(this, 1));

        if(savedInstanceState == null){
            Bundle b = getIntent().getExtras();
            if(b != null){

                takePhoto();
                nuevaPersona();

            }
        }

        if(!list.isEmpty()){

            MyAdapter adapter = new MyAdapter(list);
            Collections.sort(list, new Comparator<personas>() {
                @Override
                public int compare(personas o1, personas o2) {
                    return o1.getTrys().compareTo(o2.getTrys());
                }
            });
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
        String intentosIntent = "Intentos: " + Integer.toString(getIntent().getIntExtra("intentos", -1));
        String tiempoIntent = "Tiempo: " + Integer.toString(getIntent().getIntExtra("tiempo", -1)) + " segundos";
        Uri imageView = mAbsolutePath;

        personas p = new personas(nombreIntent, intentosIntent, tiempoIntent, imageView);
        list.add(p);
    }
    private void takePhoto() {

        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File photoFile = null;

        try {
            photoFile = createPhotoFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Uri photoUri = FileProvider.getUriForFile(this, "com.example.prueba1.provider", photoFile);
        takePicture.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        mAbsolutePath = photoUri;
        startActivityForResult(takePicture, REQUEST_TAKE_PHOTO);
    }
    private File createPhotoFile() throws IOException {

        String timestamp = new SimpleDateFormat( "yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timestamp + "_";

        File storageFile = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File photoFile = File.createTempFile(
                imageFileName, ".jpg",
                storageFile
        );

        return photoFile;
    }
}