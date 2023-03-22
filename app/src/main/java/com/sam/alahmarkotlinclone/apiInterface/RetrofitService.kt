package com.mobapps.taskapp.apiinterface


import com.sam.alahmarkotlinclone.login.LoginModel
import com.sam.alahmarkotlinclone.register.RegistrationModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
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


    @Multipart
    @POST("")
    fun getRegister(@Part("username") userName: RequestBody,
                    @Part("email") email: RequestBody,
                    @Part("phone_number") phoneNumber: RequestBody,
                    @Part("password") password: RequestBody,
                    @Part image : MultipartBody ): Call<RegistrationModel>

   /* @GET("products/{id}")
    fun getproductDetail(@Path("id") id: String): Call<ProductDetailResponse>?*/
}