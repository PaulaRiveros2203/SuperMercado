package com.example.papeleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void agregarProd (View view){
        Intent agregarProd = new Intent(this, AgregarProductos.class);
        startActivity(agregarProd);



    }
    public void datosPersonales (View view){
        Intent cargarDatosPersonales = new Intent(this, CargarDatosPersonales.class);
        startActivity(cargarDatosPersonales);
    }
   public void registro (View view){
       Intent cargarInfoPersonales = new Intent(this,  CargarInfoUsuario.class);
       startActivity(cargarInfoPersonales);
   }
   public  void tablaProd (View view){
       Intent abrirProducto = new Intent(this,  TablaProductos.class);
       startActivity(abrirProducto);

   }
}
