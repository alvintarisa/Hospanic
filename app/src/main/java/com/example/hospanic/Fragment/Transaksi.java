package com.example.hospanic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospanic.Adapter.TransaksiAdapter;
import com.example.hospanic.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Transaksi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Transaksi extends Fragment {
    private RecyclerView recyclerView;
    private TransaksiAdapter adapter;

    public Transaksi() {
        // Required empty public constructor
    }

    public static Transaksi newInstance(String param1, String param2) {
        Transaksi fragment = new Transaksi();
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
        View view = inflater.inflate(R.layout.fragment_home_transaksi, container, false);

        recyclerView = view.findViewById(R.id.recycle_view_transaksi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TransaksiAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }

}