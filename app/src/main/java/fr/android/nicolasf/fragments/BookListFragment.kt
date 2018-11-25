package fr.android.nicolasf.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.android.nicolasf.HenriPotierService
import fr.android.nicolasf.R
import fr.android.nicolasf.adapter.RecyclerAdapter
import fr.android.nicolasf.book.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class BookListFragment : Fragment() {

    companion object {
        private val STEP_0 = "This is step 0"
    }

    //private var textView: TextView? = null
    private var listBookView: RecyclerView? = null
    private var listener: OnBookPressedListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        // TODO cast context to listener
        when(context){
            is OnBookPressedListener -> listener = context
            else -> throw Exception("pas le bon uesh")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_booklist, container, false)

        // TODO find TextView and set text
        // textView = view.findViewById(R.id.textView)
        //listBookView = view.findViewById(R.id.bookListView)

        // on récupère la liste des livres

        val retrofit = Retrofit.Builder().baseUrl("http://henri-potier.xebia.fr/").addConverterFactory(GsonConverterFactory.create()).build()

        // TODO create a service

        val api = retrofit.create(HenriPotierService::class.java)

        // TODO listBooks()
        var listBooks: Array<Book>? = null

        val books = api.listBooks()

        // TODO enqueue call and display book title

        books.enqueue(object : Callback<Array<Book>> {

            override fun onFailure(call: Call<Array<Book>>, t: Throwable) {
                //Timber.i(t)
                Log.e("on failure enqueue", t.toString())
            }

            override fun onResponse(call: Call<Array<Book>>,
                                    response: Response<Array<Book>>) {

                listBooks = response.body()
                val myRecyclerView = view!!.findViewById<RecyclerView>(R.id.bookListView)
                myRecyclerView.layoutManager = LinearLayoutManager(this@BookListFragment.context)
                myRecyclerView.adapter = RecyclerAdapter(this@BookListFragment.context,listBooks, {e -> onPressedBook(e)})


            }
        })

        return view
    }

    fun onPressedBook(b: Book){
        listener?.onBookSelect(b)
    }


    interface OnBookPressedListener {
        // TODO add onNext() method
        fun onBookSelect(b: Book)
    }

}
