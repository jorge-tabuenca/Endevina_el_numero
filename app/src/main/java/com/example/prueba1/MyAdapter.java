package com.example.prueba1;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolderDatos> {

    ArrayList<personas> list;

    public MyAdapter(ArrayList<personas> list) {
        this.list = list;
    }

    @NonNull
    @Override
    //Enlace de adaptador con el ItemList
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_list, null, false);

        return new ViewHolderDatos(view);
    }

    @Override
    //Enlace Adaptador y la clase de ViewHolderDatos
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.asignarDatos(list.get(position));

    }

    @Override
    //Retornar tamaño de la lista
    public int getItemCount() {

        return list.size();

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView name;
        TextView trys;
        TextView time;
        ImageView image;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            trys = itemView.findViewById(R.id.trys);
            time = itemView.findViewById(R.id.time);
            image = itemView.findViewById(R.id.image);

        }

        public void asignarDatos(personas p) {

            name.setText(p.getName());
            trys.setText(p.getTrys());
            time.setText(p.getTime());
            image.setImageURI(p.getImage());

        }
    }
}