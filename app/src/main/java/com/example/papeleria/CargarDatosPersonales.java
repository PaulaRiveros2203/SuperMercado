package com.example.papeleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.papeleria.constants.Constantes;
import com.example.papeleria.entities.DatosPersonales;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CargarDatosPersonales extends AppCompatActivity {
    private EditText nombre, apellido, email, numeroDocumento, telefono, celular;

    private RadioGroup radioGroupTipoDocumento;

    private RadioButton radioButtonCC, radioButtonCE;
    private Switch acepto ;


    private  DatosPersonales datosPersonales;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_datos_personales);
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellido = (EditText) findViewById(R.id.editTextApellido);
        email = (EditText) findViewById(R.id.editTextEmail);
        numeroDocumento = (EditText) findViewById(R.id.editTextNumeroDocumento);
        telefono = (EditText) findViewById(R.id.editTextTelefono);
        celular = (EditText) findViewById(R.id.editTextCelular);
        acepto = (Switch) findViewById(R.id.switchAcepto);

        radioGroupTipoDocumento = (RadioGroup) findViewById(R.id.rgTipoDocumento);
        radioButtonCC = (RadioButton) findViewById(R.id.rbtncc);
        radioButtonCE = (RadioButton) findViewById(R.id.rbtnce);


        cargarDatosPersonales();
    }
    public void guardarDatosPersonales(View view){
        datosPersonales.setNombre(nombre.getText().toString());
        datosPersonales.setApellido(apellido.getText().toString());
        datosPersonales.setEmail(email.getText().toString());
        datosPersonales.setNumeroDocumento(numeroDocumento.getText().toString());
        datosPersonales.setTelefono(telefono.getText().toString());
        datosPersonales.setCelular(celular.getText().toString());
        datosPersonales.setAcepto(acepto.isChecked());

        String tipoDocumento = "";

        if (radioButtonCC.isChecked()){
            tipoDocumento = "CC";
        }
        if (radioButtonCE.isChecked()){
            tipoDocumento = "CE";
        }

        datosPersonales.setTipoDocumento(tipoDocumento);

        try {
            FileOutputStream fos = openFileOutput(Constantes.ARCHIVO_CARGA_LOCAL_DATOS_PERSONALES, Context.MODE_PRIVATE);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(datosPersonales);
            oss.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();

        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

        public void cargarDatosPersonales(){
        try {
            FileInputStream fin = openFileInput(Constantes.ARCHIVO_CARGA_LOCAL_DATOS_PERSONALES);
            ObjectInputStream oin = new ObjectInputStream(fin);
            datosPersonales = (DatosPersonales) oin.readObject();
            oin.close();

            nombre.setText(datosPersonales.getNombre());
            apellido.setText(datosPersonales.getApellido());
            email.setText(datosPersonales.getEmail());
            numeroDocumento.setText(datosPersonales.getNumeroDocumento());
            telefono.setText(datosPersonales.getTelefono());
            celular.setText(datosPersonales.getCelular());
            acepto.setChecked(datosPersonales.isAcepto());

            if (datosPersonales.getTipoDocumento().equals("CC")) {
                radioButtonCC.setChecked(true);
            }

            if (datosPersonales.getTipoDocumento().equals("CE")){
                radioButtonCE.setChecked(true);
            }

        } catch (Exception e) {
            datosPersonales = new DatosPersonales();
        }
    }
}