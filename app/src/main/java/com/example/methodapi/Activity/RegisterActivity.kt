package com.example.methodapi.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.methodapi.databinding.ActivityRegisterBinding
import com.example.methodapi.model.DataResponse
import com.example.methodapi.service.ApiClient
import com.musnadil.day6ch5.model.RequestRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMasuk.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            registerAction(email,password,username)
        }
    }
    private fun registerAction(email: String, pass: String, username : String){
        val request = RequestRegister(email,username,pass)
        ApiClient.instance.register(request)
            .enqueue(object : Callback<DataResponse> {
                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {
                    val code = response.code()
                    if (code == 201){
                        Toast.makeText(this@RegisterActivity, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
                    }else{
                        Toast.makeText(this@RegisterActivity, "Registrasi Error", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }

            })
    }
}