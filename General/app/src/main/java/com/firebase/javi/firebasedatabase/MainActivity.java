package com.firebase.javi.firebasedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEdad;
    Button buttonAddPersona;
    Spinner spinnerGenero;

    DatabaseReference databaseUsuarios;
    public static String identificador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseUsuarios = FirebaseDatabase.getInstance().getReference("Usuarios");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAddPersona = (Button) findViewById(R.id.buttonAddPersona);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        editTextEdad = (EditText) findViewById(R.id.editTextEdad);

        buttonAddPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnadirUsuario();
                Intent siguiente = new Intent(MainActivity.this, MActivity.class);
                if(editTextName.length()>2) {
                    if (editTextEdad.length()>0) {
                        if (spinnerGenero != null) {
                            startActivity(siguiente);
                        }
                    }
                }
            }
        });
    }

    public void AnadirUsuario(){
        String nombre = editTextName.getText().toString().trim();
        String edad = editTextEdad.getText().toString().trim();
        String genero= spinnerGenero.getSelectedItem().toString();


        if(!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(edad)){

            String id = databaseUsuarios.push().getKey();

            Usuario usuario = new Usuario(id, nombre,genero,edad);

            identificador = usuario.getUsuarioId();

            databaseUsuarios.child(id).setValue(usuario);

            Toast.makeText(this,"Usuario Añadido", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "Revisa que has escrito tu nombre y tu edad", Toast.LENGTH_LONG).show();
        }

    }
}
