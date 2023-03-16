package com.sam.taskappsam.repo


import com.mobapps.taskapp.retrofit.ApiClient
import com.sam.alahmarkotlinclone.login.LoginModel
import retrofit2.Call

class ProductListRepository {

    val apiInterface = ApiClient.getRetrofitService()

    fun getLogin(name : String, password : String, device_token : String) : Call<LoginModel>{
        return apiInterface?.getLogin(name,password,device_token)!!
    }

    /*fun getProductList(): Call<ArrayList<ProductListModel>>? {
        return apiInterface?.getproductlist()
    }*/
}