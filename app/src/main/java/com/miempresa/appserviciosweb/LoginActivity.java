package com.miempresa.appserviciosweb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.miempresa.appserviciosweb.api.ApiClient;
import com.miempresa.appserviciosweb.api.request.LoginRequest;
import com.miempresa.appserviciosweb.api.response.LoginResponse;
import com.miempresa.appserviciosweb.util.AlertasUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnIngresar;
    private TextView tvRegistro;

    private Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle(R.string.login);
        enlazarElementos();
        configurarEventoClick();
    }

    private void mostrarDialogoCarga() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle("Login");
            progressDialog.setMessage("Validando datos");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    private void ocultarDialogoCarga() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void validarCampos() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty()) {

            // llamar al WS de login

            LoginRequest request = new LoginRequest();
            request.setEmail(email);
            request.setPassword(password);

            mostrarDialogoCarga();

            ApiClient
                    .getApiService()
                    .login(request)
                    .enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            Log.i("Login", "onResponse: ");
                            ocultarDialogoCarga();

                            if (response.isSuccessful()) {

                                LoginResponse datosResponse = response.body();

                                if (datosResponse.isSuccess()) {
                                    Log.i("login", "onResponse exitoso | id_usuario: " + datosResponse.getId_usuario());
                                    Log.i("login", "onResponse exitoso | nombres: " + datosResponse.getNombres());
                                    Log.i("login", "onResponse exitoso | apellidos: " + datosResponse.getApellidos());
                                    Log.i("login", "onResponse exitoso | token sesion: " + datosResponse.getTokenSesion());

                                    Intent iListadoNoticias = new Intent(context, ListaNoticiasActivity.class);
                                    startActivity(iListadoNoticias);
                                    finish();


                                } else {
                                    //AlertasUtil.mostrarMensajeError(context, datosResponse.getMensaje());

                                    Log.i("login", "onResponse fallo: " + datosResponse.getMensaje());

                                }

                            }

                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e("Login", "onFailure: ");
                            ocultarDialogoCarga();
                        }
                    });

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
