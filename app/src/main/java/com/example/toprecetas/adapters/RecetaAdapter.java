package com.example.toprecetas.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toprecetas.R;
import com.example.toprecetas.activities.RecetaActivity;
import com.example.toprecetas.models.Categoria;
import com.example.toprecetas.models.Receta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder> {

    private static List<Receta> recetas;

    public RecetaAdapter() {
        recetas = new ArrayList<>();

        // Crea una lista de recetas

        //receta paella
        recetas.add(new Receta("Paella", new ArrayList<String>() {{
            add("500gr de Arroz");
            add("Un Pollo");
            add("Medio Conejo");
            add("200gr de Tomate triturado");
            add("Dos puñados de Judías verdes");
            add("Medio Pimiento rojo");
            add("Medio Pimiento verde");
            add("4 alcachofas");
            add("200gr de Garrofón");
            add("1 diente de Ajo");
            add("Azafrán");
            add("Aceite");
            add("Sal");
            add("Agua");
        }}, "1. En una paella cuanto más grande mejor, se sofríe en abundante aceite el pollo, el conejo, las judías, las alcachofas y los caracoles y el garrofón, sazonando con un poco de sal y pimentón hacia el final. Cuando esté bien dorado se añade el tomate triturado y se rehoga.\n\n" +
                "2. Con el sofrito listo se debe de añadir tres veces el volumen de agua que de arroz, aunque es la experiencia la que os hará ajustar y perfeccionar estas cantidades.\n\n" +
                "3. Subimos el fuego y cocemos durante 25 minutos. Es un buen momento de echar el azafrán o colorante de paella.\n\n" +
                "4. Luego añadimos el arroz y lo distribuimos por la paella. Bajamos el fuego y cocemos entre 17 y 20 minuto. A mitad cocción también podemos poner unas ramitas de romero, que retiraremos antes de servir.\n\n" +
                "5. Por último, conviene dejar la paella reposar unos minutos tapada con un gran paño o papel de periódico.", R.drawable.paella,
                    new Categoria("ARROCES", R.drawable.arroces)
                ));

        // receta arroz al horno
        recetas.add(new Receta("Arroz al horno", new ArrayList<String>() {{
            add("Arroz");
            add("Costilla de cerdo");
            add("Morcilla");
            add("Patata");
            add("Tomate");
            add("Garbanzos");
            add("Ajo");
            add("Aceite");
            add("Sal");
        }}, "\"1. En una paella cuanto más grande mejor, se sofríe en abundante aceite el pollo, el conejo, las judías, las alcachofas y los caracoles y el garrofón, sazonando con un poco de sal y pimentón hacia el final. Cuando esté bien dorado se añade el tomate triturado y se rehoga.\n\n" +
                "                \"2. Con el sofrito listo se debe de añadir tres veces el volumen de agua que de arroz, aunque es la experiencia la que os hará ajustar y perfeccionar estas cantidades.\n\n" +
                "                \"3. Subimos el fuego y cocemos durante 25 minutos. Es un buen momento de echar el azafrán o colorante de paella.\n\n" +
                "                \"4. Luego añadimos el arroz y lo distribuimos por la paella. Bajamos el fuego y cocemos entre 17 y 20 minuto. A mitad cocción también podemos poner unas ramitas de romero, que retiraremos antes de servir.\n\n" +
                "                \"5. Por último, conviene dejar la paella reposar unos minutos tapada con un gran paño o papel de periódico.", R.drawable.arroz_al_horno,
                new Categoria("ARROCES", R.drawable.arroces)
                ));

        // receta arroz del senyoret
        recetas.add(new Receta("Arroz del senyoret", new ArrayList<String>() {{
            add("Arroz");
            add("Gambas");
            add("Sepia");
            add("Calamar");
            add("Mejillones");
            add("Pimiento rojo");
            add("Pimiento verde");
            add("Ajo");
            add("Tomate");
            add("Aceite");
            add("Sal");
            add("Perejil");
        }}, "1. Cocer los mejillones en agua con sal durante 5 minutos. Escurrir y reservar.\n\n" +
                "2. Cocer las gambas en agua con sal durante 5 minutos. Pelar y reservar.\n\n" +
                "3. Cocer la sepia y el calamar en agua con sal durante 5 minutos. Escurrir y reservar.\n\n" +
                "4. En una sartén con aceite, sofreír el ajo y los pimientos cortados en daditos.\n\n" +
                "5. Añadir el tomate rallado y sofreír durante 5 minutos.\n\n" +
                "6. Añadir el arroz y sofreír durante 5 minutos.\n\n" +
                "7. Añadir el caldo de pescado y cocer durante 15 minutos.\n\n" +
                "8. Añadir las gambas, la sepia, el calamar y los mejillones.\n\n" +
                "9. Cocer durante 5 minutos.\n\n" +
                "10. Servir caliente.", R.drawable.arroz_del_senyoret,
                new Categoria("ARROCES", R.drawable.arroces)
                ));

        // receta arroz tres delicias
        recetas.add(new Receta("Arroz tres delicias", new ArrayList<String>() {{
            add("Arroz");
            add("Jamón cocido");
            add("Gambas");
            add("Huevo");
            add("Guisantes");
            add("Aceite");
            add("Sal");
            add("Salsa de soja");
        }}, "1. Cocer el arroz en agua con sal durante 15 minutos. Escurrir y reservar.\n\n" +
                "2. Cocer los guisantes en agua con sal durante 10 minutos. Escurrir y reservar.\n\n" +
                "3. Cocer las gambas en agua con sal durante 5 minutos. Escurrir y reservar.\n\n" +
                "4. Cocer los huevos en agua con sal durante 10 minutos. Pelar y reservar.\n\n" +
                "5. En una sartén con aceite, saltear el jamón cocido cortado en daditos.\n\n" +
                "6. Añadir las gambas peladas y saltear durante 2 minutos.\n\n" +
                "7. Añadir el arroz, los guisantes y los huevos cocidos cortados en daditos.\n\n" +
                "8. Saltear durante 5 minutos.\n\n" +
                "9. Añadir la salsa de soja y saltear durante 2 minutos.\n\n" +
                "10. Servir caliente.", R.drawable.arroz_tres_delicias,
                new Categoria("ARROCES", R.drawable.arroces)
                ));

        // receta tarta tres chocolates
        recetas.add(new Receta("Tarta tres chocolates", new ArrayList<String>() {{
            add("150gr. de chocolate blanco de cobertura");
            add("150gr. de chocolate con leche de cobertura");
            add("150gr. de chocolate negro de cobertura");
            add("1l. de nata para montar");
            add("500m. de leche");
            add("3 sobres de cuajada en polvo");
            add("6 láminas de gelatina");
            add("125gr. de azúcar");
            add("200gr. de galletas digestive");
            add("80gr. de mantequilla");
        }},
                "1. Tritura las galletas y mézclalas con la mantequilla ablandada. Forra con papel de horno la base de un molde desmontable de tarta de 23 cm de diámetro y cúbrela con esta masa.\n\n" +
                "2. Reserva la masa en la nevera unos 30 minutos para que se endurezca y mientras, deja las hojas de gelatina en remojo de agua fría 5 minutos.\n\n" +
                "3. Mezcla la nata con la leche y divide la mezcla en 3 partes. Calienta a fuego lento una parte con 1 sobre de cuajada y 2 hojas de gelatina escurridas. Añade el chocolate blanco previamente rallado y remueve hasta que se funda. Viértelo sobre la base de galleta y deja reposar hasta que empiece a cuajarse.\n\n" +
                "4. Repite la operación con el chocolate con leche, una tercera parte de la mezcla de nata y leche, 1 sobre de cuajada, otras 2 hojas de gelatina y 50 g de azúcar. Haz unas incisiones sobre el chocolate blanco con un tenedor y vierte la mezcla anterior para que se adhiera mejor, dejándola caer sobre una cuchara para que caiga más suavemente.\n\n" +
                "5. Funde en la mezcla de nata restante el último sobre de cuajada, 2 hojas de gelatina, 75 g de azúcar y el chocolate negro rallado. Vierte esta crema sobre la tarta, a la que habrás hecho también unos surcos con el tenedor, y no muevas el molde hasta que esta empiece a cuajarse.\n\n" +
                "6. Reserva la tarta en la nevera durante unas 12 horas antes de servir. Para decorar, añádele unas virutas de los tres chocolates utilizados, por encima.",

                R.drawable.tarta_tres_chocolates,
                new Categoria("POSTRES", R.drawable.postres)
               ));

        //receta tarta chocolate blanco y queso
        recetas.add(new Receta("Tarta chocolate blanco y queso", new ArrayList<String>() {{
            add("Harina");
            add("Azúcar");
            add("Mantequilla");
            add("Huevo");
            add("Chocolate blanco");
            add("Fresas");
            add("Levadura");
            add("Azúcar glass");
        }}, "Preparación:\n" +
                "1. Tritura las galletas en la picadora picando con un mortero para que se desmenuzarlas." +
                "2. Templar la mantequilla para que esté blanda o en pomada y mezclar con las galletas hasta lograr una especie de masa de galletas. Forrar el fondo del molde con esta masa de galletas y dejar reposar en la nevera.\n\n" +
                "3. Hidratamos la gelatina, para ello preparamos en un recipiente amplio para que las hojas no estén unas encimas de otras. Ponemos media taza de agua y dejar que repose 10 minutos.\n\n" +
                "4. Añade la leche a un cazo y ponerla al fuego hasta que llegue a ebullición. Cuando hierva añadir las hojas empapadas de agua.\n\n" +
                "5. Mezclar el queso crema con la nata y reservar.\n\n" +
                "6. Rallar o trocear el chocolate, añadir en un recipiente y verter la leche con gelatina. Añadir el queso crema y la nata y mezclar todos los ingredientes hasta tener una crema homogénea.\n\n" +
                "7. Batir las claras de huevo a punto de nieve con una batidora o unas varillas , vamos a preparar un merengue. Comenzar batiendo suave  y cuando las claras se vayan espumando añade una cucharada de azúcar, sigue batiendo y agrega otra hasta incorporar todo el azúcar.\n\n" +
                "8. Una vez tengamos el merengue añadimos poco a poco a la masa de chocolate blanco del punto nº 5 hasta integrar los ingredientes. Verter sobre el molde con base de galletas. Cubrir con film de plástico y cuando esté a temperatura ambiente introducir en la nevera durante 8 horas antes de servir.",
                R.drawable.tarta_chocolate_blanco_rapida,
                new Categoria("POSTRES", R.drawable.postres)
                ));

        // receta natillas
        recetas.add(new Receta("Natillas", new ArrayList<String>() {{
            add("Leche");
            add("Azúcar");
            add("Huevo");
            add("Maicena");
            add("Canela");
            add("Limón");
        }}, "1. En un cazo, calentar la leche con la piel de limón y la canela en rama.\n\n" +
                "2. En un bol, batir las yemas de huevo con el azúcar y la maicena.\n\n" +
                "3. Retirar la piel de limón y la canela de la leche y verter la leche caliente sobre la mezcla de huevo, azúcar y maicena.\n\n" +
                "4. Mezclar bien y verter la mezcla en el cazo.\n\n" +
                "5. Cocer a fuego lento, sin dejar de remover, hasta que espese.\n\n" +
                "6. Verter las natillas en cuencos y dejar enfriar.\n\n" +
                "7. Espolvorear con canela molida antes de servir.", R.drawable.natillas,
                new Categoria("POSTRES", R.drawable.postres)
                ));

        // receta torrijas
        recetas.add(new Receta("Torrijas", new ArrayList<String>() {{
            add("Pan");
            add("Leche");
            add("Azúcar");
            add("Huevo");
            add("Canela");
            add("Limón");
            add("Aceite");
        }}, "1. Cortar el pan en rebanadas de 1 cm de grosor.\n\n" +
                "2. En un cazo, calentar la leche con la piel de limón y la canela en rama.\n\n" +
                "3. En un bol, batir los huevos.\n\n" +
                "4. Pasar las rebanadas de pan por la leche y después por el huevo batido.\n\n" +
                "5. Freír las rebanadas de pan en aceite caliente hasta que estén doradas.\n\n" +
                "6. Escurrir las torrijas sobre papel absorbente.\n\n" +
                "7. Mezclar el azúcar con la canela y rebozar las torrijas con esta mezcla.", R.drawable.torrijas,
                new Categoria("POSTRES", R.drawable.postres)
                ));
    }

    public static List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetasFiltradas) {
        this.recetas = recetasFiltradas;
    }

    @NonNull
    @Override
    public RecetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.receta_item, parent, false);
        return new RecetaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecetaViewHolder holder, int position) {

        final boolean[] favorito = {false};
        Receta receta = recetas.get(position);
        holder.nombre.setText(receta.getNombre());
        holder.foto.setImageResource(receta.getFoto());

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(v.getContext(), RecetaActivity.class);
                    intent.putExtra("nombreReceta", recetas.get(position).getNombre());
                    intent.putExtra("fotoReceta", recetas.get(position).getFoto());
                    intent.putExtra("preparacionReceta", recetas.get(position).getPreparacion());

                    // Concatena los ingredientes en una sola cadena
                    String ingredientes= "";
                    for(String ingrediente : recetas.get(position).getIngredientes()) {
                        ingredientes += "· " + ingrediente + "\n";

                    }
                    // elimina el ultimo salto de linea de la cadena
                    ingredientes = ingredientes.substring(0, ingredientes.length() - 1);
                    intent.putExtra("ingredientesReceta", ingredientes);
                    v.getContext().startActivity(intent);
                }
            }
        });

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(v.getContext(), RecetaActivity.class);
                    intent.putExtra("nombreReceta", recetas.get(position).getNombre());
                    intent.putExtra("fotoReceta", recetas.get(position).getFoto());
                    intent.putExtra("preparacionReceta", recetas.get(position).getPreparacion());

                    // Concatena los ingredientes en una sola cadena
                    String ingredientes= "";
                    for(String ingrediente : recetas.get(position).getIngredientes()) {
                        ingredientes += "· " + ingrediente + "\n";

                    }
                    // elimina el ultimo salto de linea de la cadena
                    ingredientes = ingredientes.substring(0, ingredientes.length() - 1);
                    intent.putExtra("ingredientesReceta", ingredientes);
                    v.getContext().startActivity(intent);
                }
            }
        });


        holder.fabFavorito.setColorFilter(ContextCompat.getColor(holder.itemView.getContext(), R.color.colorPrimaryDark));

        holder.fabFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!favorito[0]) {
                    // Realizar la animación
                    v.animate().rotation(v.getRotation() + 360).setDuration(500).start();
                    // Cambiar el color del icono
                    holder.fabFavorito.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.colorAccent));
                    favorito[0] = true;
                    // Mostrar un mensaje de confirmación de que se ha añadido a favoritos la receta con un Toast
                    Toast.makeText(v.getContext(), "Receta añadida a favoritos", Toast.LENGTH_SHORT).show();

                } else {
                    // Realizar la animación
                    v.animate().rotation(v.getRotation() - 360).setDuration(500).start();
                    // Cambiar el color del icono
                    holder.fabFavorito.setColorFilter(ContextCompat.getColor(v.getContext(), R.color.colorPrimaryDark));
                    favorito[0] = false;
                    // Mostrar un mensaje de confirmación de que se ha eliminado de favoritos la receta con un Toast
                    Toast.makeText(v.getContext(), "Receta eliminada de favoritos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }



    public static class RecetaViewHolder extends RecyclerView.ViewHolder {

        public FloatingActionButton fabFavorito;
        TextView nombre;
        ImageView foto;
        CardView cardView;

        public RecetaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            foto = itemView.findViewById(R.id.ivReceta);
            cardView = itemView.findViewById(R.id.cvReceta);
            fabFavorito = itemView.findViewById(R.id.fabFavorito);
        }
    }
}