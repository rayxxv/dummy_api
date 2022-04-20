package com.example.methodapi.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.methodapi.MainActivity
import com.example.methodapi.databinding.ActivityLoginBinding
import com.example.methodapi.model.LoginResponse
import com.example.methodapi.service.ApiClient
import com.musnadil.day6ch5.model.RequestLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMasuk.setOnClickListener {
            loginAction(binding.etUsername.text.toString(),binding.etPassword.text.toString())
        }
        binding.btnDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    private fun loginAction(email : String, pass: String){
        val request = RequestLogin(email,pass)

        ApiClient.instance.login(request)
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val code = response.code()
                    if(code == 200){
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }else{
                        Toast.makeText(this@LoginActivity, "gagal login", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}