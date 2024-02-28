package com.example.toprecetas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toprecetas.R;
import com.example.toprecetas.adapters.RecetaAdapter;
import com.example.toprecetas.models.Receta;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class CategoriaSeleccionadaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecetaAdapter recetaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_seleccionada);

        // Establece el color de la barra de navegación
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary, null));

        // Obtiene el nombre de la categoría del Intent
        String categoriaSeleccionada = getIntent().getStringExtra("categoria_seleccionada");

        // Establece el título de la categoría
        TextView tituloCategoria = findViewById(R.id.titulo_tv);
        tituloCategoria.setText(categoriaSeleccionada);

        // Obtén todas las recetas del RecetaAdapter
        RecetaAdapter recetaAdapter = new RecetaAdapter();
        List<Receta> todasLasRecetas = recetaAdapter.getRecetas();

        Log.d("CategoriaSeleccionada", "Categoria seleccionada: " + categoriaSeleccionada);
        // Filtra la lista de recetas por la categoría seleccionada
        List<Receta> recetasFiltradas = new ArrayList<>();
        for (Receta receta : todasLasRecetas) {
            if (receta.getCategoria().getNombre().equals(categoriaSeleccionada)) {
                recetasFiltradas.add(receta);
            }
        }

        // Configura el RecyclerView con la lista filtrada
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecetaAdapter recetaAdapter2 = new RecetaAdapter();
        recetaAdapter2.setRecetas(recetasFiltradas);
        recyclerView.setAdapter(recetaAdapter2);


        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        Animation slideDownToolbar = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.slide_down_toolbar);
        toolbar.startAnimation(slideDownToolbar);

        // Configurar el NavigationView
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.nav_inicio) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
            else if (id == R.id.nav_categorias) {
                Intent intent = new Intent(this, ListaCategoriasActivity.class);
                startActivity(intent);
            }
            else if(id == R.id.nav_ingrediente) {
                Intent intent = new Intent(this, BuscadorActivity.class);
                startActivity(intent);
            }
            else if (id == R.id.nav_favoritos) {
                Intent intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
            } else if (id == R.id.nav_todas) {
                Intent intent = new Intent(this, TodasActivity.class);
                startActivity(intent);
            }
            // Cierra el DrawerLayout
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}
