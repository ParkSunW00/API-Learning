package com.example.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApplicationService {

    //정보를 가져옴
    @GET("/student/{path}")
    public Call<ResponseBody> getData(
            @Path("path") int number
    );

    //정보를바꿈
    @FormUrlEncoded
    @POST("/student")
    //서버에서 주는 값 그대로
    public Call<ResponseBody> setData (
            @Field("number") int number,
            @Field("name") String name
            );
}
