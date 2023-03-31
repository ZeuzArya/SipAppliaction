package com.example.sipappliaction.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.sipappliaction.data.model.AdminModel
import com.example.sipappliaction.data.model.UserModel
import com.example.sipappliaction.databinding.ActivityMainBinding
import com.example.sipappliaction.feature.admin.AdminPage
import com.example.sipappliaction.feature.home.Home
import com.example.sipappliaction.feature.signup.CreateAccount

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.isEnabled = false

        binding.tvCreateAccount.setOnClickListener {
            startActivity(Intent(this@MainActivity, CreateAccount::class.java))
        }

        binding.inputNameOfUser.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
        }

        binding.inputPassword2.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
        }

        binding.btnLogin.setOnClickListener {
            validateUser()
        }
    }

    private fun validateInput(){
        binding.btnLogin.isEnabled = binding.inputNameOfUser.editText?.text.toString().isNotBlank()
                && binding.inputPassword2.editText?.text.toString().isNotBlank()
    }

    private fun validateUser(){
        if (binding.inputNameOfUser.editText?.text.toString() == UserModel.username &&
                binding.inputPassword2.editText?.text.toString() == UserModel.password){
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity, Home::class.java))
        } else if(binding.inputNameOfUser.editText?.text.toString() == AdminModel.username &&
                binding.inputPassword2.editText?.text.toString() == AdminModel.password){
            Toast.makeText(this, "Login Sebagai Admin", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AdminPage::class.java))
        }else {
            Toast.makeText(this, "Akun Belum Terdaftar", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}