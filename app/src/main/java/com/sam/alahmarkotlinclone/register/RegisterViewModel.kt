package com.sam.alahmarkotlinclone.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sam.alahmarkotlinclone.login.LoginModel
import com.sam.taskappsam.repo.ProductListRepository
import okhttp3.Callback
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val productRepo: ProductListRepository = ProductListRepository()

    fun getRegister(userName : RequestBody, email : RequestBody, phoneNumber : RequestBody,
                    password : RequestBody, image : MultipartBody) : MutableLiveData<RegistrationModel>{
        val registerResponse = MutableLiveData<RegistrationModel>()
        val response = productRepo.getRegister(userName,email, phoneNumber ,password,image)


        response?.enqueue(object : retrofit2.Callback<RegistrationModel> {

            override fun onFailure(call: Call<RegistrationModel>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.e("product ","errr "+t.message)
            }

            override fun onResponse(
                call: Call<RegistrationModel>,
                response: Response<RegistrationModel>
            ) {
                registerResponse.postValue(response.body())
            }
        })

        return registerResponse
    }


}