package com.example.hospanic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.tugasakhirsistempakar.Model.SoalModel;
import com.example.hospanic.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ListViewHolder> {
    private Context mContext;
//    private ArrayList<SoalModel> soal;


    @NonNull
    @Override
    public HomeAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_home, parent, false);
        return new ListViewHolder(view);
    }

    public HomeAdapter(Context mContext){
        this.mContext = mContext;
//        this.soal = soal;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        holder.text.setText("Ini Judul");
        holder.gambar.setImageResource(R.drawable.ilus1);
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
//        return soal.size();
        return 2;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        private ImageView gambar;
        private TextView text;
//      cb_soal
        public ListViewHolder(View itemView){
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar_card_main_menu);
            text = itemView.findViewById(R.id.text_card_main_menu);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

//    public ArrayList<SoalModel> getJawaban(){
//        return soal;
//    }
}
