package com.example.appapi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cep = binding.etcep.toString()
        val btncaep = binding.btncep

        btncaep.setOnClickListener {
            if (cep.isNullOrEmpty()) {
                Toast.makeText(this, "Digite o CEP corretamente", Toast.LENGTH_SHORT).show()
            } else {
                buscarEndereco(cep)
            }
        }

    }

    private fun buscarEndereco(cep: String) {
        val retrofitClient = RetrofitUtils.getRetrofitInstance("https://viacep.com.br/")
        val endpoint = retrofitClient.create(InterRetro::class.java)


        endpoint.get(cep).enqueue(object : Callback<CEPModel> {
            override fun onFailure(call: Call<CEPModel>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }


            override fun onResponse(
                call: Call<CEPModel>, response: Response<CEPModel>
            ) {
                val txtresul = binding.txtreultado
                val cepModel = response.body()

                if (cepModel != null) {
                    txtresul?.text = "Longradouro: ${cepModel?.logradouro} \n" +
                            "Bairro: ${cepModel?.bairro} \n" +
                            "UF: ${cepModel?.uf}"
                } else {
                    Toast.makeText(baseContext, "Endereço não encontrado.", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        })

    }

}


