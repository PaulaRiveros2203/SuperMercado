package app.inventario.papeleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.papeleria.R;

import app.inventario.papeleria.constants.Constantes;
import app.inventario.papeleria.entities.Producto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AgregarProductos extends AppCompatActivity {
    private EditText nombreProd, precioProd, cantidadProd, precioVenta;
    private Spinner spinnerTipo;
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        abrirProducto();
        setContentView(R.layout.agregar_productos);
        nombreProd = (EditText) findViewById(R.id.editTextText);
        precioProd = (EditText) findViewById(R.id.e_precioprod);
        cantidadProd = (EditText) findViewById(R.id.editTextNumber);
        precioVenta = (EditText) findViewById(R.id.editTextNumberDecimal2);
        spinnerTipo = (Spinner) findViewById(R.id.spinner);
        String[] opciones = {"Frescos", "Cuidado del hogar", "Despensa", "otros"};
        ArrayAdapter<String> listaOpcionesTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinnerTipo.setAdapter(listaOpcionesTipo);

    }

    public void agregar(View view) {
        Producto nuevoProducto = new Producto();

        nuevoProducto.setNombre(nombreProd.getText().toString());
        nuevoProducto.setCantidad(Integer.parseInt(cantidadProd.getText().toString()));
        nuevoProducto.setPrecio(Double.parseDouble(precioProd.getText().toString()));
        nuevoProducto.setVenta(Double.parseDouble(precioVenta.getText().toString()));
        nuevoProducto.setTipo(spinnerTipo.getSelectedItem().toString());

        listaProductos.add(nuevoProducto);

        guardarProducto();
        Toast.makeText(this, "Producto guardado", Toast.LENGTH_SHORT).show();

        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void guardarProducto() {
        try {
            FileOutputStream fos = openFileOutput(Constantes.ARCHIVO_CARGA_LOCAL_INVENTARIO, Context.MODE_PRIVATE);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(listaProductos);
            oss.close();
        } catch (Exception e) {
            e.printStackTrace();

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