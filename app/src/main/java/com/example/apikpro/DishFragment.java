package com.example.apikpro;

import android.content.Context;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.ComidaAdapter;
import Api.ServiceApi;
import Model.Comida;
import Util.conexionREST;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DishFragment extends Fragment {

    private List<Comida> comidas;
    private RecyclerView recyclerView;
    private ComidaAdapter comidaAdapter;
    private ServiceApi api;//llamando a ala api
    private DrawerLayout drawerLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dish, container, false);
        api = conexionREST.getConnection().create(ServiceApi.class);

        recyclerView = view.findViewById(R.id.rv_comidas);
        showComida();
        // Inflate the layout for this fragment
        return view;
    }

    void showComida() {
        Call<List<Comida>> call = api.listComids();
        call.enqueue(new Callback<List<Comida>>() {
            @Override
            public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                if (response.isSuccessful()) {
                    comidas = response.body();
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    comidaAdapter = new ComidaAdapter(comidas, getContext());
                    recyclerView.setAdapter(comidaAdapter);

                    comidaAdapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getContext(), "Seleccion : ", Toast.LENGTH_SHORT).show();

                        }
                    });// Cambio aquí
                    System.out.println(comidas);
                } else {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show(); // Cambio aquí
                }
            }

            @Override
            public void onFailure(Call<List<Comida>> call, Throwable t) {
                Toast.makeText(requireContext(), "Ocurrió un error inesperado", Toast.LENGTH_SHORT).show(); // Cambio aquí
            }
        });
    }


}