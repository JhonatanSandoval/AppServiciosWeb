package com.miempresa.appserviciosweb;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.miempresa.appserviciosweb.adapter.NoticiasAdapter;

public class ListaNoticiasActivity extends AppCompatActivity {

    private RecyclerView rvNoticias;
    private NoticiasAdapter noticiasAdapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_noticias);

        enlazarElementos();
        configurarRecycler();
        consultarListadoNoticias();
    }

    private void consultarListadoNoticias() {
        // llamar al WS de listado de noticias

    }

    private void configurarRecycler() {
        rvNoticias.setLayoutManager(new LinearLayoutManager(context));
        noticiasAdapter = new NoticiasAdapter();
        rvNoticias.setAdapter(noticiasAdapter);
    }

    private void enlazarElementos() {
        context = ListaNoticiasActivity.this;

        rvNoticias = findViewById(R.id.rvNoticias);
    }
}
