package com.sam.alahmarkotlinclone.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sam.alahmarkotlinclone.R
import com.sam.alahmarkotlinclone.utility.SharedPreferenceUtil
import com.sam.alahmarkotlinclone.utility.StaticKey
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    lateinit var userEmail : AppCompatEditText
    lateinit var userPassword : AppCompatEditText
    lateinit var loginButton : AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        userEmail = findViewById(R.id.user_email_edittext)
        userPassword = findViewById(R.id.uesr_password_edittext)
        loginButton = findViewById(R.id.login_button)


        loginButton.setOnClickListener(View.OnClickListener {

            Toast.makeText(this, "Login button clicked", Toast.LENGTH_SHORT).show()

            if(validation()){
                viewModel.getLogin(userEmail.text.toString(),userPassword.text.toString(),"dskdjlfs132").observe(this, Observer {
                    it.let {


                        Log.d("test_sam",it.status)
                        Log.d("test_sam",it.message)
                        val token = it.token
                        Log.d("test_sam",token.toString())
                        SharedPreferenceUtil.saveAccessToken(token.access.toString())
                        val accessToken = SharedPreferenceUtil.getAccessToken()
                        Log.d("test_sam",accessToken.toString()+"ok")
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                    }
                })

            }
        })

    }

    private fun validation(): Boolean {
        if(userEmail.text.toString().trim().equals("")){
            Toast.makeText(this, "Please enter user email",Toast.LENGTH_SHORT)
            return false
        }else if(userPassword.text.toString().trim().equals("")){
            Toast.makeText(this, "Please enter user password",Toast.LENGTH_SHORT)
            return false
        }
        return true
    }
}