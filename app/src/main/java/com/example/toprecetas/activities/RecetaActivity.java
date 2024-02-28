package com.example.toprecetas.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toprecetas.R;
import com.google.android.material.navigation.NavigationView;

public class RecetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        // Establece el color de la barra de navegación
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary, null));

        TextView tvNombre = findViewById(R.id.nombreReceta_tv);
        TextView tvPreparacion = findViewById(R.id.preparacion_tv);
        TextView tvIngredientes = findViewById(R.id.ingredientes_tv);
        ImageView ivFoto = findViewById(R.id.imagen_iv);

        // Obtiene los datos del Intent
        Intent intent1 = getIntent();
        String nombreReceta = intent1.getStringExtra("nombreReceta");
        int fotoReceta = intent1.getIntExtra("fotoReceta", 0);
        String preparacionReceta = intent1.getStringExtra("preparacionReceta");
        String ingredientesReceta = intent1.getStringExtra("ingredientesReceta");

        // Usa los datos para actualizar la interfaz de usuario
        tvNombre.setText(nombreReceta);
        ivFoto.setImageResource(fotoReceta);
        tvPreparacion.setText("PREPARACIÓN:\n" + preparacionReceta);
        tvIngredientes.setText("INGREDIENTES:\n" + ingredientesReceta);

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