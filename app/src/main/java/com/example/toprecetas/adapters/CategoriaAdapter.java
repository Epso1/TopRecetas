package com.example.toprecetas.adapters;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toprecetas.R;
import com.example.toprecetas.activities.CategoriaSeleccionadaActivity;
import com.example.toprecetas.models.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {
    private List<Categoria> categorias;

    // Constructor
    public CategoriaAdapter() {
        categorias = new ArrayList<>();
        categorias.add(new Categoria("SOPAS", R.drawable.sopas));
        categorias.add(new Categoria("ARROCES", R.drawable.arroces));
        categorias.add(new Categoria("CARNES", R.drawable.carnes));
        categorias.add(new Categoria("ENSALADAS", R.drawable.ensaladas));
        categorias.add(new Categoria("PASTA", R.drawable.pasta));
        categorias.add(new Categoria("PESCADO", R.drawable.pescados));
        categorias.add(new Categoria("POSTRES", R.drawable.postres));
    }


    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        Categoria categoria = categorias.get(position);
        holder.bind(categoria);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aplicar la animación
                Animator textColorChange = AnimatorInflater.loadAnimator(v.getContext(), R.animator.text_color_change);
                textColorChange.setTarget(holder.nombre);
                textColorChange.start();

                // Iniciar la actividad de la categoría seleccionada
                Intent intent = new Intent(v.getContext(), CategoriaSeleccionadaActivity.class);
                intent.putExtra("categoria_seleccionada", categoria.getNombre());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView nombre;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvCategoria);
        }

        public void bind(Categoria categoria) {
            nombre.setText(categoria.getNombre());
        }
    }
}
