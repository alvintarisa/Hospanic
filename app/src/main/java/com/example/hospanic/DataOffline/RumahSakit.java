package com.example.hospanic.DataOffline;

import java.util.ArrayList;
import java.util.List;

public class RumahSakit {

    public RumahSakit(){
        data();
    }
//    Nama, deskripsi, alamat, no telp, gambar
    private static List<String[]> allData;
    public int nama = 0, deskripsi = 1, alamat = 2, noTelp = 3, gambar = 4;
    private int[][] antrean = {{1, 0, 5, 3}, {2, 2, 6, 1}, {1, 0, 0, 0}, {9, 9, 9, 9}};
    private static void data(){
        allData = new ArrayList<String[]>();
        String[] data1 = {"RSUD. Soetomo", "Ini adalah Rumah Sakit RSUD. Soetomo", "Jl. Mayjen Prof. Dr. Moestopo No.6-8 Surabaya, Jawa Timur", "081098765432", "rumah_sakit2"};
        allData.add(data1);
        String[] data2 = {"RS. Bhayangkara", "Ini adalah Rumah Sakit RS. Bhayangkara", "Jl. Abdurahman Saleh VI No.56, Kab. Nganjuk, Jawa Timur", "081098765432", "rumah_sakit3"};
        allData.add(data2);
        String[] data3 = {"RS. Muhammadiyah Ahmad Dahlan", "Ini adalah RS. Muhammadiyah Ahmad Dahlan", "Jl. Gatot Subroto No.84, Kec. Mojoroto, Kediri, Jawa Timur", "rumah_sakit4"};
        allData.add(data3);
    }

    public List<String[]> getAllData(){
        return allData;
    }

    public String[] getItem(int id){
        return allData.get(id);
    }

    public int getAntrean(int id_rumah_sakit, int id_spesifikasi){
        return antrean[id_rumah_sakit][id_spesifikasi];
    }

    public void menambahAntrean(int id_rumah_sakit, int id_spesifikasi){
        antrean[id_rumah_sakit][id_spesifikasi]+=1;
    }
}
