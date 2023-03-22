package com.sam.taskappsam.repo


import com.mobapps.taskapp.retrofit.ApiClient
import com.sam.alahmarkotlinclone.login.LoginModel
import com.sam.alahmarkotlinclone.register.RegistrationModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call

class ProductListRepository {

    val apiInterface = ApiClient.getRetrofitService()

    fun getLogin(name : String, password : String, device_token : String) : Call<LoginModel>{
        return apiInterface?.getLogin(name,password,device_token)!!
    }

    fun getRegister(userName : RequestBody, email : RequestBody, phoneNumber : RequestBody,
    password : RequestBody , image : MultipartBody) : Call<RegistrationModel>{
        return apiInterface!!.getRegister(userName,email, phoneNumber ,password,image)
    }

    /*fun getProductList(): Call<ArrayList<ProductListModel>>? {
        return apiInterface?.getproductlist()
    }*/
}