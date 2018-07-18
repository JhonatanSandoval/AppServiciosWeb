package com.miempresa.appserviciosweb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.miempresa.appserviciosweb.util.AlertasUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnIngresar;
    private TextView tvRegistro;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(R.string.login);
        enlazarElementos();
        configurarEventoClick();
    }

    private void validarCampos() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty()) {

            // llamar al WS de login


        } else {
            AlertasUtil.mostrarMensajeError(context, R.string.ningun_campo_puede_estar_vacio);

        }
    }

    private void configurarEventoClick() {
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCampos();
            }
        });
        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVentanaRegistro();
            }
        });
    }

    private void abrirVentanaRegistro() {
        startActivity(new Intent(context, RegistroActivity.class));
        finish();
    }

    private void enlazarElementos() {
        context = LoginActivity.this;

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        tvRegistro = findViewById(R.id.tvRegistro);
    }
}
