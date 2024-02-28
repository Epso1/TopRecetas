package com.example.toprecetas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

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

public class BuscadorActivity extends AppCompatActivity {
    private EditText ingredientSearch;
    private Button searchButton;
    private RecyclerView recyclerView;
    private RecetaAdapter recetaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        // Establece el color de la barra de navegación
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary, null));


        ingredientSearch = findViewById(R.id.ingredient_search);
        searchButton = findViewById(R.id.search_button);
        recyclerView = findViewById(R.id.recycler_view);

        // Configura el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recetaAdapter = new RecetaAdapter();
        recyclerView.setAdapter(recetaAdapter);

        // Configura el botón de búsqueda
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredienteBuscado = ingredientSearch.getText().toString().toUpperCase();
                System.out.println("************ Ingrediente buscado:" + ingredienteBuscado);
                List<Receta> allRecipes = recetaAdapter.getRecetas();
                List<Receta> recetasFiltradas = new ArrayList<>();
                for (Receta receta : allRecipes) {
                    System.out.println("********Receta consultada:" + receta.getNombre());
                    for (String ingrediente : receta.getIngredientes()) {
                        String ingrediente1 = ingrediente.toUpperCase();
                        System.out.println("********Ingrediente consultado:" + ingrediente1);
                        if (ingrediente1.contains(ingredienteBuscado)) {
                            recetasFiltradas.add(receta);
                            break;
                        }
                    }
                }

                // Configura el RecyclerView con la lista filtrada
                RecetaAdapter recetaAdapter2 = new RecetaAdapter();
                recetaAdapter2.setRecetas(recetasFiltradas);
                recyclerView.setAdapter(recetaAdapter2);
            }
        });

        // Configura el Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        // Animación de Toolbar
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