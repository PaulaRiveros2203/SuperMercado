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

   public  void tablaProd (View view){
       Intent abrirProducto = new Intent(this,  TablaProductos.class);
       startActivity(abrirProducto);

   }
   public void eliminarprod (View view){
        Intent eliminarprod = new Intent(this, EliminarProducto.class);
                startActivity(eliminarprod);
   }
}
