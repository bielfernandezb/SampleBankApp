package com.bielfernandezb.samplebank.presentation.login.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bielfernandezb.samplebank.databinding.ActivityLoginBinding
import com.bielfernandezb.samplebank.presentation.BaseActivity
import com.bielfernandezb.samplebank.presentation.transaction.view.activity.MainActivity
import com.bielfernandezb.samplebank.presentation.utils.Utils

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgLogin.setOnClickListener {
            validateData(this)
        }
    }

    private fun validateData(context: Context) {
        val id = Utils.convertStringToInt(binding.inputUserId.text.toString())
        val pass = Utils.convertStringToInt(binding.inputPassword.text.toString())
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