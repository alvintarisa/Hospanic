package com.example.hospanic.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hospanic.DataOffline.RumahSakit;
import com.example.hospanic.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Reservasi extends AppCompatActivity {
    private ImageView btn_back;
    private Button btn_submit;
    private TextView namaRumahSakit;
    private EditText namaPasien, alamatPasien;
    private Spinner kesediaanBPJS, keterangan;
    private RumahSakit rumahSakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasi);

        int data = getIntent().getIntExtra("position", 0);

        rumahSakit = new RumahSakit();

        btn_back = findViewById(R.id.btn_back_reservasi);
        namaRumahSakit = findViewById(R.id.nama_rumah_sakit_reservasi);
        namaPasien = findViewById(R.id.nama_pasien);
        alamatPasien = findViewById(R.id.alamat_pasien);
        kesediaanBPJS = findViewById(R.id.kesediaan_bpjs);
        keterangan = findViewById(R.id.keterangan_reservasi);
        btn_submit = findViewById(R.id.btn_submit_reservasi);

        setValue(data);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reservasi.super.onBackPressed();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_keterangan = keterangan.getSelectedItemPosition();
                int antrean = rumahSakit.getAntrean(data, id_keterangan)+1;
                rumahSakit.menambahAntrean(data, id_keterangan);
                String tunggu = "C-";
                if(antrean>10){
                    tunggu+=("0"+antrean);
                    if(antrean>100){
                        tunggu+=(""+antrean);
                    }
                }else{
                    tunggu+=("00"+antrean);
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(Reservasi.this);
                alert.setTitle("Pendaftaran sudah diproses");
                alert.setMessage("Nomor antrean Anda adalah "+tunggu);
                alert.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Reservasi.super.onBackPressed();
                    }
                });
                alert.show();
            }
        });

    }

    private void setValue(int position){
        String[] itemBPJS = new String[] {"Iya", "Tidak"};
        String[] itemKeterangan = new String[] {"-", "Spesialis Anak", "Spesialis Jantung", "Spesialis Paru-paru"};
        ArrayAdapter<String> arrayAdapterBPJS = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itemBPJS);
        ArrayAdapter<String> arrayAdapterKeterangan = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itemKeterangan);
        namaRumahSakit.setText(rumahSakit.getItem(position)[rumahSakit.nama]);
        kesediaanBPJS.setAdapter(arrayAdapterBPJS);
        keterangan.setAdapter(arrayAdapterKeterangan);

    }
}