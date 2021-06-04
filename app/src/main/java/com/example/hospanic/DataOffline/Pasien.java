package com.example.hospanic.DataOffline;

import java.util.ArrayList;
import java.util.List;

public class Pasien {
    private static List<String[]> allData;
    private String[][] data;
    public int nomorUrut = 0, nama = 1, alamat = 2, kesediaanbpjs = 3, keterangan = 4;

    public Pasien(){
        data();
    }

    private static void data(){
        allData = new ArrayList<String[]>();
        String[] data1 = {"C-006","Joko", "Jln. Merah muda", "Iya", "Jantung"};
        allData.add(data1);
        String[] data2 = {"C-005", "Andri", "Jln. Kelapa muda", "Tidak", "-"};
        allData.add(data2);

//        data = new String[][] {{"C-006","Joko", "Jln. Merah muda", "Iya", "Jantung"},{"C-005", "Andri", "Jln. Kelapa muda", "Tidak", "-"}};
    }

    public String[] getItem(int id_pasien){
        return allData.get(id_pasien);
    }
}
