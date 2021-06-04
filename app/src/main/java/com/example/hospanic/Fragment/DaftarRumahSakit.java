package com.example.hospanic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospanic.Activity.MainMenu;
import com.example.hospanic.Activity.Reservasi;
import com.example.hospanic.Adapter.DaftarRumahSakitAdapter;
import com.example.hospanic.Adapter.HomeAdapter;
import com.example.hospanic.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaftarRumahSakit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DaftarRumahSakit extends Fragment {
    private RecyclerView recyclerView;
    private DaftarRumahSakitAdapter adapter;
    private DaftarRumahSakitAdapter.RecyclerViewClickListenerDaftarRumahSakit listenerDaftarRumahSakit;

    public DaftarRumahSakit() {
        // Required empty public constructor
    }

    public static DaftarRumahSakit newInstance(String param1, String param2) {
        DaftarRumahSakit fragment = new DaftarRumahSakit();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_daftar_rumah_sakit, container, false);

//        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_home);
//        HomeAdapter homeAdapter = new HomeAdapter(getContext());
//        recyclerView.setAdapter(homeAdapter);

        setOnClickListener();
        recyclerView = view.findViewById(R.id.recycle_view_daftar_rumah_sakit);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DaftarRumahSakitAdapter(getActivity(), listenerDaftarRumahSakit);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void setOnClickListener(){
        listenerDaftarRumahSakit = new DaftarRumahSakitAdapter.RecyclerViewClickListenerDaftarRumahSakit() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getActivity(), Reservasi.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        };
    }
}