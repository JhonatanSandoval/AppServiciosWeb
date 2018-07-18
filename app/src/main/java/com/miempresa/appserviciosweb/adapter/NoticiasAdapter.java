package com.miempresa.appserviciosweb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miempresa.appserviciosweb.R;
import com.miempresa.appserviciosweb.model.NoticiaModel;

import java.util.ArrayList;
import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiasHolder> {

    private List<NoticiaModel> noticias = new ArrayList<>();
    private Context context;

    @Override
    public NoticiasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NoticiasHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticia, parent, false));
    }

    @Override
    public void onBindViewHolder(NoticiasHolder holder, int position) {
        try {
            holder.pintarCelda(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public void setNoticias(List<NoticiaModel> noticias) {
        this.noticias = noticias;
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    class NoticiasHolder extends RecyclerView.ViewHolder {

        private ImageView ivImagenNoticia;
        private TextView tvTituloNoticia;

        public NoticiasHolder(View itemView) {
            super(itemView);

            ivImagenNoticia = itemView.findViewById(R.id.ivImagenNoticia);
            tvTituloNoticia = itemView.findViewById(R.id.tvTituloNoticia);
        }

        public void pintarCelda(int position) {
            NoticiaModel noticia = noticias.get(position);


        }
    }

}
