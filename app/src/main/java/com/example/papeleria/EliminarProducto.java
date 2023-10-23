package com.example.papeleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.papeleria.constants.Constantes;
import com.example.papeleria.entities.Producto;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EliminarProducto extends AppCompatActivity {
    private EditText nombreProd;
    private Spinner spinnerTipo;
    private ArrayList<Producto> listaProductos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_producto);
        nombreProd = (EditText) findViewById(R.id.editTextText);
        spinnerTipo = (Spinner) findViewById(R.id.spinner);
        String[] opciones = {"Frescos", "Cuidado del hogar", "Despensa", "otros"};
        ArrayAdapter<String> listaOpcionesTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinnerTipo.setAdapter(listaOpcionesTipo);

    }
    public void eliminar (View view) {
        Producto nuevoProducto = new Producto();

        nuevoProducto.setNombre(nombreProd.getText().toString());
        nuevoProducto.setTipo(spinnerTipo.getSelectedItem().toString());

        listaProductos.add(nuevoProducto);

        EliminarProd();
        Toast.makeText(this, "Producto Eliminado", Toast.LENGTH_SHORT).show();

        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
    public void EliminarProd() {
        try {
            FileOutputStream fos = openFileOutput(Constantes.ARCHIVO_CARGA_LOCAL_INVENTARIO, Context.MODE_PRIVATE);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(listaProductos);
            oss.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}