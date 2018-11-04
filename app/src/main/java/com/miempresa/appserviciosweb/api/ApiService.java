package com.miempresa.appserviciosweb.api;

import com.miempresa.appserviciosweb.api.request.LoginRequest;
import com.miempresa.appserviciosweb.api.request.RegistroRequest;
import com.miempresa.appserviciosweb.api.response.LoginResponse;
import com.miempresa.appserviciosweb.api.response.RegistroResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/login.php")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("api/registro.php")
    Call<RegistroResponse> registro(@Body RegistroRequest request);

}
