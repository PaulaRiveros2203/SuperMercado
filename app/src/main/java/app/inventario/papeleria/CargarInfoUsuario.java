package app.inventario.papeleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.papeleria.R;

import app.inventario.papeleria.constants.Constantes;
import app.inventario.papeleria.entities.Registrarse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CargarInfoUsuario extends AppCompatActivity {
    private EditText nombre, descripcion;
    private Button registrarse;
    private Registrarse registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_info_usuario);
        nombre = (EditText) findViewById(R.id.editTextTextNAME);
        descripcion = (EditText) findViewById(R.id.editTextTextdescripcion);
        cargarInfoPersonales();
    }

    public void registrodatos(View view) {
        registro = new Registrarse();
        registro.setNombre(nombre.getText().toString());
        registro.setDescripcion(descripcion.getText().toString());
        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();

        try {
            FileOutputStream fos = openFileOutput(Constantes.ARCHIVO_CARGA_LOCAL_REGISTRO, Context.MODE_PRIVATE);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(registro);
            oss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void cargarInfoPersonales() {
        try {
            FileInputStream fin = openFileInput(Constantes.ARCHIVO_CARGA_LOCAL_REGISTRO);
            ObjectInputStream oin = new ObjectInputStream(fin);
            registro = (Registrarse) oin.readObject();
            oin.close();

            nombre.setText(registro.getNombre());
            descripcion.setText(registro.getDescripcion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}