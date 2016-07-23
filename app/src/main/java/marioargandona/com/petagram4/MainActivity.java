package marioargandona.com.petagram4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    public MascotaAdapter adapter;
    public Integer likesRecibidos = 0;
    public TextView tvLikes;
    public TextView tvNombreMascota;
    public ImageButton btnFavoritos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascota);
        tvNombreMascota = (TextView) listaMascotas.findViewById(R.id.tvNombreMascota);
        tvLikes = (TextView)listaMascotas.findViewById(R.id.tvLikesMascota);
        btnFavoritos = (ImageButton)findViewById(R.id.btnFavoritos);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        /*Bundle parametros = getIntent().getExtras();

        if(parametros != null)
        {
            likesRecibidos = parametros.getInt("likes");
            if(likesRecibidos != 0)
            {
                Integer likesTotales = 0;

                if(listaMascotas == null)
                {
                    tvLikes = (TextView)findViewById(R.id.tvLikesMascota);
                }

                likesTotales = Integer.valueOf(tvLikes.getText().toString()) + likesRecibidos;
                tvLikes.setText(likesTotales);

            }
        }*/

        iniciaListaMascotas();
        iniciaAdapterMascotas();

        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , MascotaFavorita.class);
                startActivity(intent);
            }
        });


    }


    private void iniciaListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Spark"    , 0     , R.drawable.mascota1));
        mascotas.add(new Mascota("Coffee"   , 0     , R.drawable.mascota2));
        mascotas.add(new Mascota("Kaiser"   , 0     , R.drawable.mascota3));
        mascotas.add(new Mascota("Shamuu"   , 0     , R.drawable.mascota4));
        mascotas.add(new Mascota("Bingo"    , 0     , R.drawable.mascota5));
    }



    private void iniciaAdapterMascotas()
    {
        adapter = new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adapter);
    }

}
