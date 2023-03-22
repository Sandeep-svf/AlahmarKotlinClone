package com.sam.alahmarkotlinclone.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sam.alahmarkotlinclone.R
import com.sam.alahmarkotlinclone.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater) //initializing the binding class
        setContentView(binding.root)






    }
}