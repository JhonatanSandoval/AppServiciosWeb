package com.miempresa.appserviciosweb.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.miempresa.appserviciosweb.R;

public class AlertasUtil {

    public static void mostrarMensajeError(Context context, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(mensaje)
                .setPositiveButton(R.string.aceptar, null);
        builder.show();
    }

    public static void mostrarMensajeError(Context context, int resMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(resMessage)
                .setPositiveButton(R.string.aceptar, null);
        builder.show();
    }

}
