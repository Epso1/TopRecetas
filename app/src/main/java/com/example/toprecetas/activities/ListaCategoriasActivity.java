package com.example.toprecetas.activities;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;

import com.example.toprecetas.R;
import com.example.toprecetas.adapters.CategoriaAdapter;
import com.google.android.material.navigation.NavigationView;

public class ListaCategoriasActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoriaAdapter categoriaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);

        // Establece el color de la barra de navegación
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary, null));

        // Configura el RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoriaAdapter = new CategoriaAdapter();
        recyclerView.setAdapter(categoriaAdapter);

        // Configurar el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        // Animación de aparición del Toolbar
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