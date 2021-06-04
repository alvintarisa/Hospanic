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
import com.example.hospanic.DataOffline.Pasien;
import com.example.hospanic.DataOffline.RumahSakit;
import com.example.hospanic.R;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.ListViewHolder> {
    private Context mContext;
    private Pasien pasien;


    @NonNull
    @Override
    public TransaksiAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_transaksi, parent, false);
        return new ListViewHolder(view);
    }

    public TransaksiAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        pasien = new Pasien();
        holder.nomorUrut.setText(pasien.getItem(position)[pasien.nomorUrut]);
        holder.namaPasien.setText(pasien.getItem(position)[pasien.nama]);
        holder.alamatPasien.setText(pasien.getItem(position)[pasien.alamat]);
        holder.kesediaanBPJS.setText(pasien.getItem(position)[pasien.kesediaanbpjs]);
        holder.keterangan.setText(pasien.getItem(position)[pasien.keterangan]);
    }

    @Override
    public int getItemCount() {
        return 2;
//        return rumahSakit.getAllData().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        private TextView namaPasien, alamatPasien, kesediaanBPJS, keterangan, nomorUrut;
        public ListViewHolder(View itemView){
            super(itemView);
            nomorUrut = itemView.findViewById(R.id.nomorUrut);
            namaPasien = itemView.findViewById(R.id.nama_pasien_telah_daftar);
            alamatPasien = itemView.findViewById(R.id.alamat_pasien_telah_daftar);
            kesediaanBPJS = itemView.findViewById(R.id.keterangan_telah_datar);
            keterangan = itemView.findViewById(R.id.keterangan_telah_datar);
        }

    }

}
