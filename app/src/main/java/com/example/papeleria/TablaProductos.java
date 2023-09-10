package com.example.papeleria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.papeleria.constants.Constantes;
import com.example.papeleria.entities.Producto;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TablaProductos extends AppCompatActivity {

    private ArrayList<Producto> listaProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_productos);
        abrirProducto();

        TableLayout tlInventario = findViewById(R.id.tlInventario);
        for (Producto producto:listaProductos){
            TableRow tr = new TableRow(this);

            TextView tvNombre = new TextView(this);
            TextView tvTipo = new TextView(this);
            TextView tvCantidad = new TextView(this);
            TextView tvPrecio = new TextView(this);
            TextView tvVenta = new TextView(this);

            tvNombre.setText(producto.getNombre());
            tvTipo.setText(producto.getTipo());
            tvCantidad.setText(Integer.toString(producto.getCantidad()));
            tvPrecio.setText(String.format("%,.2f", (producto.getPrecio())));
            tvVenta.setText(String.format("%,.2f", (producto.getVenta())));

            tr.addView(tvNombre);
            tr.addView(tvTipo);
            tr.addView(tvCantidad);
            tr.addView(tvPrecio);
            tr.addView(tvVenta);

            tlInventario.addView(tr);
        }
    }

    public void abrirProducto() {
        try {
            FileInputStream fin = openFileInput(Constantes.ARCHIVO_CARGA_LOCAL_INVENTARIO);
            ObjectInputStream oin = new ObjectInputStream(fin);
            listaProductos = (ArrayList<Producto>) oin.readObject();
            oin.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}