package marioargandona.com.petagram4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotaFavorita extends AppCompatActivity {

    public ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotasDummy;
    public MascotaFavoritaAdapter adapter;
    public Integer likesRecibidos = 0;
    public TextView tvLikesDummy;
    public TextView tvNombreMascotaDummy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasDummy = (RecyclerView)findViewById(R.id.rvMascota2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasDummy.setLayoutManager(llm);

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
    }



    private void iniciaListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Kizaru"    , 16     , R.drawable.mascota5));
        mascotas.add(new Mascota("Akainu"   , 18     , R.drawable.mascota4));
        mascotas.add(new Mascota("Rafe"   , 3     , R.drawable.mascota2));
        mascotas.add(new Mascota("Kuro"   , 2     , R.drawable.mascota3));
        mascotas.add(new Mascota("Coco"    , 6     , R.drawable.mascota1));


    }



    private void iniciaAdapterMascotas()
    {
        adapter = new MascotaFavoritaAdapter(mascotas,this);
        listaMascotasDummy.setAdapter(adapter);
    }
}
