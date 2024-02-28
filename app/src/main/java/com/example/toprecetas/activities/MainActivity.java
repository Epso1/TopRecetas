package com.example.toprecetas.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.toprecetas.R;

public class MainActivity extends AppCompatActivity {
    Button button;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Establece el color de la barra de navegación
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary, null));

        button = findViewById(R.id.start_btn);
        cardView = findViewById(R.id.cardView);
        setUp();
    }
    // Método para ejecutar las animaciones cuando la actividad se reanuda
    @Override
    protected void onResume() {
        super.onResume();

        cardView = findViewById(R.id.cardView);
        button = findViewById(R.id.start_btn);
        cardView.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        setUp();
    }

    // Método para configurar las animaciones
    public void setUp(){
        Animation slideDownCard = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down_card);
        cardView.startAnimation(slideDownCard);
        Animation slideUpBtn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up_btn);
        button.startAnimation(slideUpBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Animación de botón
                Animation slideDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down_btn);
                button.startAnimation(slideDown);

                // Animación de tarjeta
                Animation slideUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up_card);
                slideUp.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    // Navegar a HomeActivity
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Navegar a ListaCategoriasActivity
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        // Aplicar la transición de fundido
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        cardView.setVisibility(View.GONE);
                        button.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                // Iniciar la animación de la tarjeta
                cardView.startAnimation(slideUp);
            }
        });
    }
}