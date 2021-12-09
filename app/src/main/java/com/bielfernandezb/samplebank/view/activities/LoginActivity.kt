package com.bielfernandezb.samplebank.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bielfernandezb.samplebank.databinding.ActivityLoginBinding
import com.bielfernandezb.samplebank.utils.Utils

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener(View.OnClickListener {
            validateData(this)
        })
    }

    private fun validateData(context: Context) {
        val id = Utils.convertStringToInt(binding.userid.text.toString())
        val pass = Utils.convertStringToInt(binding.password.text.toString())
        if (id == 1234 && pass == 1234) {
            moveOn(context)
        }
    }

    private fun moveOn(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
        finish()
    }
}