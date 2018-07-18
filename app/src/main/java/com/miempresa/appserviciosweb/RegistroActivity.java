package com.miempresa.appserviciosweb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.miempresa.appserviciosweb.util.AlertasUtil;

public class RegistroActivity extends AppCompatActivity {

    private EditText etNombres, etApellidos, etEmail, etPassword;
    private Button btnRegistrar, btnRegresar;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setTitle(R.string.registro);
        enlazarElementos();
        configurarEventoClick();

    }

    private void validarCamposRegistro() {
        String nombres = etNombres.getText().toString().trim();
        String apellidos = etApellidos.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (!nombres.isEmpty() && !apellidos.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

            // llamar al WS de registro


        } else {
            AlertasUtil.mostrarMensajeError(context, R.string.ningun_campo_puede_estar_vacio);

        }
    }

    private void configurarEventoClick() {
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCamposRegistro();
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarLogin();
            }
        });
    }

    private void regresarLogin() {
        startActivity(new Intent(context, LoginActivity.class));
        finish();
    }

    private void enlazarElementos() {
        context = RegistroActivity.this;

        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegresar = findViewById(R.id.btnRegresar);
    }

}
