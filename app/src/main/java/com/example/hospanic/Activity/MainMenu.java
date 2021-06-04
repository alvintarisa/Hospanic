package com.example.hospanic.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.hospanic.Adapter.HomeAdapter;
import com.example.hospanic.R;
import com.example.hospanic.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainMenu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private ImageView btn_panic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager_home);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs_main_menu);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.main_menu_icon);
        tabs.getTabAt(1).setIcon(R.drawable.daftar_rumah_sakit_icon);
        tabs.getTabAt(2).setIcon(R.drawable.transaksi_icon);
        tabs.getTabAt(3).setIcon(R.drawable.user);

        btn_panic = findViewById(R.id.btn_panic);
        btn_panic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainMenu.this)
                        .setTitle("Panic Button")
                        .setMessage("Apakah Anda dalam kondisi darurat?")
                        .setPositiveButton("Iya!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                View imageView = View.inflate(MainMenu.this, R.layout.alert_lokasi, null);
//                                ImageView image = imageView.findViewById(R.id.gambar_lokasi);
                                AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(MainMenu.this)
                                        .setTitle("Panic Button")
                                        .setMessage("Apakah lokasi Anda berada sekarang sudah sesuai?")
                                        .setView(imageView)
                                        .setPositiveButton("Lanjut", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                View checkBoxView = View.inflate(MainMenu.this, R.layout.alert_checkboxes, null);
                                                CheckBox cb_jantung = checkBoxView.findViewById(R.id.cb_jantung);
                                                CheckBox cb_luka_bakar = checkBoxView.findViewById(R.id.cb_luka_bakar);
                                                CheckBox cb_sesak_nafas = checkBoxView.findViewById(R.id.cb_sesak_nafas);
                                                CheckBox cb_pendarahan = checkBoxView.findViewById(R.id.cb_pendarahan_fatal);

                                                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainMenu.this)
                                                        .setTitle("Panic Button")
                                                        .setMessage("Pilih untuk mendeskripsi keadaan Anda")
                                                        .setView(checkBoxView)
                                                        .setPositiveButton("Lanjut", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                Intent intent = new Intent(MainMenu.this, Panic.class);
                                                                startActivity(intent);
                                                            }
                                                        })
                                                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                dialogInterface.dismiss();
                                                            }
                                                        });
                                                alertDialog2.show();
                                            }
                                        })
                                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        });
                                alertDialog1.show();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }
}