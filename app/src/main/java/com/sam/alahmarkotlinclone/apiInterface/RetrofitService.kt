package com.mobapps.taskapp.apiinterface


import com.sam.alahmarkotlinclone.login.LoginModel
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {
   /* @GET("products")
    fun getproductlist(): Call<ArrayList<ProductListModel>>?*/

    @FormUrlEncoded
    @POST("login/")
    fun getLogin(@Field ("email") email : String,
                 @Field ("password") password : String,
                 @Field ("device_token") device_token : String
    ): Call<LoginModel>

   /* @GET("products/{id}")
    fun getproductDetail(@Path("id") id: String): Call<ProductDetailResponse>?*/
}