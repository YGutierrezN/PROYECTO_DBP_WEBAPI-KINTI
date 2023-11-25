package com.example.apikpro;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Api.ServiceApi;
import Model.Comida;
import Util.conexionREST;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private EditText editTextResult, editTextcodigo, editTextnombre, ediPrecio;
    private Button buttonGrabar, buttonElliminar, buttonModificar;
    private String mParam2;
    private ServiceApi api;//llamando a ala api


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        api = conexionREST.getConnection().create(ServiceApi.class);
        editTextResult = view.findViewById(R.id.editTextResult);
        editTextcodigo = view.findViewById(R.id.edtCodigo);
        ediPrecio = view.findViewById(R.id.etPrecio);
        buttonGrabar = view.findViewById(R.id.buttonGrabar);
        buttonModificar = view.findViewById(R.id.btnEdit);
        buttonElliminar = view.findViewById(R.id.btnDelete);

        cargardatosDelAPI();
        buttonGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"SI", "NO"};

                AlertDialog.Builder alertOpciones = new AlertDialog.Builder(requireContext());
                alertOpciones.setTitle("¿Deseas Grabar el Registro?");
                alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí puedes manejar la selección del usuario
                        if (opciones[which].equals("SI")) {
                            // Código para el caso "SI"
                        } else if (opciones[which].equals("NO")) {
                            // Código para el caso "NO"
                        }
                        // Puedes agregar más casos según sea necesario
                    }
                });

// Muestra el AlertDialog
                alertOpciones.show();
            }
        });

        buttonModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"SI", "NO"};

                AlertDialog.Builder alertOpciones = new AlertDialog.Builder(requireContext());
                alertOpciones.setTitle("¿Deseas Modificar el Registro?");
                alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí puedes manejar la selección del usuario
                        if (opciones[which].equals("SI")) {
                            // Código para el caso "SI"
                        } else if (opciones[which].equals("NO")) {
                            // Código para el caso "NO"
                        }
                        // Puedes agregar más casos según sea necesario
                    }
                });

// Muestra el AlertDialog
                alertOpciones.show();
            }
        });


        buttonElliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] opciones = {"SI", "NO"};

                AlertDialog.Builder alertOpciones = new AlertDialog.Builder(requireContext());
                alertOpciones.setTitle("¿Deseas eliminar el Registro?");
                alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        // Aquí puedes manejar la selección del usuario
                        if (opciones[i].equals("SI")) {


                        } else if (opciones[i].equals("NO")) {
                            // Código para el caso "NO"
                        }
                        // Puedes agregar más casos según sea necesario
                    }
                });

// Muestra el AlertDialog
                alertOpciones.show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void cargardatosDelAPI() {
        Call<List<Comida>> call = api.listComids();
        call.enqueue(new Callback<List<Comida>>() {
            @Override
            public void onResponse(Call<List<Comida>> call, Response<List<Comida>> response) {
                if (response.isSuccessful()) {
                    List<Comida> comidaList = response.body();
                    editTextResult.setText("ya\n");
                    for (Comida x : comidaList) {
                        editTextResult.append("[ " + x.getIdComida() + "." + x.getCodigoBarra() + "\n" + x.getDescripcion() + " ]" + "\n");
                    }

                } else {
                    Toast.makeText(null, "Error", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Comida>> call, Throwable t) {
                Toast.makeText(null, "Ocurrio un Error", Toast.LENGTH_LONG).show();


            }
        });


    }
}