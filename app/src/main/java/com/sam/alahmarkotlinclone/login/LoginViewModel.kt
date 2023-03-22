package com.sam.alahmarkotlinclone.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.taskappsam.repo.ProductListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val productRepo: ProductListRepository = ProductListRepository()

    fun getLogin(name : String, password : String, device_token : String) : MutableLiveData<LoginModel>{

        val loginResponse = MutableLiveData<LoginModel>()
        val response = productRepo.getLogin(name, password, device_token)

            response?.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                Log.e("product ","dd ")
                loginResponse.postValue(response.body())
            }
            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.e("product ","errr "+t.message)
            }
        })
        return loginResponse
    }

}