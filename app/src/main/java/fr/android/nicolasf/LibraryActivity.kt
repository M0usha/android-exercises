package fr.android.nicolasf

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import fr.android.nicolasf.book.Book
import fr.android.nicolasf.fragments.BookListFragment
import fr.android.nicolasf.fragments.BookDetailFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibraryActivity : AppCompatActivity(), BookListFragment.OnNextStep0Listener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)


        // on récupère la liste des livres

        val retrofit = Retrofit.Builder().baseUrl("http://henri-potier.xebia.fr/").addConverterFactory(GsonConverterFactory.create()).build()

        // TODO create a service

        val api = retrofit.create(HenriPotierService::class.java)

        // TODO listBooks()

        val books = api.listBooks()

        // TODO enqueue call and display book title

        books.enqueue(object : Callback<Array<Book>> {

            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                //Timber.i(t)
                Log.e("on failure enqueue", t.toString())
            }

            override fun onResponse(call: Call<Array<Book>>,
                                    response: Response<Array<Book>>) {

                response.body()?.forEach {
                    //Timber.i(it.title +"   "+  it.price)
                }
                //Timber.i(response.body()?.asList().toString())

            }
        })


        supportFragmentManager.beginTransaction().replace(R.id.containerFrameLayout, BookListFragment(), BookListFragment::class.java.name).commit()
        // TODO replace BookListFragment in containerFrameLayout
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction().replace(R.id.containerFrameLayout2, BookDetailFragment(), BookDetailFragment::class.java.name).commit()
        }



    }


    override fun onNext() {
        // TODO implement onNext() from BookListFragment.OnNextStep0Listener

        supportFragmentManager.beginTransaction().replace(R.id.containerFrameLayout, BookDetailFragment(), BookDetailFragment::class.java.name).addToBackStack(BookListFragment::class.java.name).commit()

    }




}
