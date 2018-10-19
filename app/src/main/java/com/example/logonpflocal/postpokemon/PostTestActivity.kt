package com.example.logonpflocal.postpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.logonpflocal.postpokemon.api.JokenpoAPI
import com.example.logonpflocal.postpokemon.model.Pontuacao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PostTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_test)

        val pontuacao = Pontuacao("Felipe Melo", 500)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(JokenpoAPI::class.java!!)
        service.enviarPontos(pontuacao)
                .enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {

                    }
                })


        service.buscarPontuacao()
                .enqueue(object : Callback<List<Pontuacao>> {
                    override fun onFailure(call: Call<List<Pontuacao>>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<List<Pontuacao>>?, response: Response<List<Pontuacao>>?) {
                        val minhaLista = response?.body()
                    }
                })
    }
}
