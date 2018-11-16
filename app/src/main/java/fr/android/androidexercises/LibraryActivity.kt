package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class LibraryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Plant logger cf. Android Timber
        Timber.plant(Timber.DebugTree());

        // TODO build Retrofit

        val retrofit = Retrofit.Builder().baseUrl("http://henri-potier.xebia.fr/").addConverterFactory(GsonConverterFactory.create()).build()

        // TODO create a service

        val api = retrofit.create(HenriPotierService::class.java)

        // TODO listBooks()

        val books = api.listBooks()

        // TODO enqueue call and display book title

        books.enqueue(object : Callback<Array<Book>> {

            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                    Timber.i(t)
            }

            override fun onResponse(call: Call<Array<Book>>,
                                    response: Response<Array<Book>>) {

                response.body()?.forEach { Timber.i(it.title +"   "+  it.price) }
                //Timber.i(response.body()?.asList().toString())

            }
        })


        // TODO log books



        // TODO display book as a list



    }

}
