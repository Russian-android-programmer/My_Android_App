package com.example.converter.api;

import com.example.converter.models.ValCurs;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

public class CBApi {

    public interface API{
        @GET("XML_daily.asp")
        Call<ValCurs> getCurrentValuteCurs();
    }

    private static Retrofit retrofit;
    private static String base = "http://www.cbr.ru/scripts/";
    private static API api;

    public static API getInstance() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .baseUrl(base)
                    .build();
            api = retrofit.create(API.class);
        }
        return api;
    }
}
