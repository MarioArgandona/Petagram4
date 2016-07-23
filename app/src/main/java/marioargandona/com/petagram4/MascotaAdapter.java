package marioargandona.com.petagram4;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Robert on 7/23/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas , Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota , parent , false);
        return new MascotaViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreMascota.setText(mascota.getNombreMascota());
        holder.tvLikes.setText(mascota.getLikes().toString());

        holder.btnLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Un huesito a: " + mascota.getNombreMascota() + "  !!!", Toast.LENGTH_SHORT).show();
                String valor = holder.tvLikes.getText().toString();
                Integer valorConvertido = Integer.valueOf(valor) + 1;
                valor = String.valueOf(valorConvertido);
                holder.tvLikes.setText(valor);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFoto;
        private TextView tvNombreMascota;
        private TextView tvLikes;
        private ImageButton btnLikes;
        private ImageButton btnFavoritos;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikesMascota);
            btnLikes = (ImageButton)itemView.findViewById(R.id.btnLike);
            btnFavoritos = (ImageButton)itemView.findViewById(R.id.btnFavoritos);
        }
    }


}
