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
import java.util.Iterator;

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

        // Cargar la lista de productos desde el archivo (si existe)
        cargarProductos();
    }

    public void eliminar(View view) {
        String nombreEliminar = nombreProd.getText().toString();
        String tipoEliminar = spinnerTipo.getSelectedItem().toString();

        // Iterar sobre la lista de productos y eliminar el producto con el nombre y tipo especificados
        Iterator<Producto> iterator = listaProductos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getNombre().equals(nombreEliminar) && producto.getTipo().equals(tipoEliminar)) {
                iterator.remove();
            }
        }

        // Guardar la lista de productos actualizada
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

    private void cargarProductos() {
        try {
            FileInputStream fis = openFileInput(Constantes.ARCHIVO_CARGA_LOCAL_INVENTARIO);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaProductos = (ArrayList<Producto>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
