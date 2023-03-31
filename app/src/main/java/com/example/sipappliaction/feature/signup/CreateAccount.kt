package com.example.sipappliaction.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.sipappliaction.R
import com.example.sipappliaction.data.model.UserModel
import com.example.sipappliaction.databinding.ActivityCreateAccountBinding
import com.example.sipappliaction.feature.MainActivity

class CreateAccount : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ArrayAdapter.createFromResource(
            this,
            R.array.levels_array, android.
            R.layout.simple_spinner_item).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                binding.spLevel.adapter = adapter
        }

        binding.btnCreate.isEnabled = false

        binding.inputNameOfUser.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
        }

        binding.inputUserName2.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
        }

        binding.inputPassword2.editText?.doOnTextChanged { text, start, before, count ->
            validateInput()
        }

        binding.btnCreate.setOnClickListener {
            startActivity(Intent(this@CreateAccount, MainActivity::class.java))
            UserModel.apply {
                nama = binding.inputNameOfUser.editText?.text.toString()
                username = binding.inputUserName2.editText?.text.toString()
                password = binding.inputPassword2.editText?.text.toString()
                level = binding.spLevel.toString()
            }
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(){
        binding.btnCreate.isEnabled =
            binding.inputNameOfUser.editText?.text.toString().isNotBlank() && binding.inputUserName2.editText?.text.toString().isNotBlank()
                    && binding.inputPassword2.editText?.text.toString().isNotBlank()
    }
}