package com.example.hospanic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hospanic.DataOffline.RumahSakit;
import com.example.hospanic.R;

import java.util.List;

public class DaftarRumahSakitAdapter extends RecyclerView.Adapter<DaftarRumahSakitAdapter.ListViewHolder> {
    private Context mContext;
    private RecyclerViewClickListenerDaftarRumahSakit listenerDaftarRumahSakit;
    private RumahSakit rumahSakit;
//    private ArrayList<SoalModel> soal;


    @NonNull
    @Override
    public DaftarRumahSakitAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_daftar_rumah_sakit, parent, false);
        return new ListViewHolder(view);
    }

    public DaftarRumahSakitAdapter(Context mContext, RecyclerViewClickListenerDaftarRumahSakit listenerDaftarRumahSakit){
        this.mContext = mContext;
        this.listenerDaftarRumahSakit = listenerDaftarRumahSakit;
//        this.soal = soal;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        rumahSakit = new RumahSakit();
        holder.namaRumahSakit.setText(rumahSakit.getItem(position)[rumahSakit.nama]);
        holder.lokasi.setText(rumahSakit.getItem(position)[rumahSakit.alamat]);
        Glide.with(mContext)
                .load(R.drawable.rumah_sakit2)
                .into(holder.gambar);
//        String gambar = "R.drawable."+rumahSakit.getItem(position)[rumahSakit.gambar];
//        holder.gambar.setImageResource(R.drawable.rumah_sakit2);
//        holder.cb_soal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (soal.get(position).getJawaban() == 1){
//                    soal.get(position).setJawaban(0);
//                }else{
//                    soal.get(position).setJawaban(1);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return 3;
//        return rumahSakit.getAllData().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView gambar;
        private TextView namaRumahSakit, ketersediaan, lokasi;
//      cb_soal
        public ListViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            gambar = itemView.findViewById(R.id.gambar_card_daftar_rumah_sakit);
            namaRumahSakit = itemView.findViewById(R.id.nama_rumah_sakit);
            ketersediaan = itemView.findViewById(R.id.kesediaan_rumah_sakit);
            lokasi = itemView.findViewById(R.id.lokasi_daftar_rumah_sakit);
        }

        @Override
        public void onClick(View view) {
            listenerDaftarRumahSakit.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListenerDaftarRumahSakit{
        void onClick(View v, int position);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

//    public ArrayList<SoalModel> getJawaban(){
//        return soal;
//    }
}
