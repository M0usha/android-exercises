package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.ListView

import java.util.ArrayList
import java.util.Locale
import java.util.Random

class LibraryActivity : AppCompatActivity() {

    companion object {
        private val RANDOM = Random()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val books = books

        // TODO findViewById() and setAdapter()

        //val bookListView = findViewById<ListView>(R.id.bookListView)
        //bookListView.adapter = BookAdapter(this, books)
        //Execute ???

        val list = findViewById<RecyclerView>(R.id.bookListView)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerAdapter(this,books)

    }

    private val books: List<Book>
        get() {
            val books = ArrayList<Book>()
            for (i in 0..99) {
                books.add(
                        Book(String.format(Locale.FRANCE, "Garry Potier Tome %d", i),
                                RANDOM.nextInt(30).toFloat())
                )
            }
            return books
        }

}
