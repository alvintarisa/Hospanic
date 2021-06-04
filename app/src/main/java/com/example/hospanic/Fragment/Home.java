package com.example.hospanic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospanic.Activity.MainMenu;
import com.example.hospanic.Adapter.HomeAdapter;
import com.example.hospanic.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    public Home() {
        // Required empty public constructor
    }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View view = inflater.inflate(R.layout.fragment_home_main_menu, container, false);

//        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_home);
//        HomeAdapter homeAdapter = new HomeAdapter(getContext());
//        recyclerView.setAdapter(homeAdapter);

        recyclerView = view.findViewById(R.id.recycle_view_home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }
}