package fr.android.nicolasf

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import fr.android.nicolasf.adapter.RecyclerAdapter
import fr.android.nicolasf.book.Book
import fr.android.nicolasf.fragments.BookListFragment
import fr.android.nicolasf.fragments.BookDetailFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibraryActivity : AppCompatActivity(), BookListFragment.OnBookPressedListener {

    private var actualBookDetailFrag: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        supportFragmentManager.beginTransaction().replace(R.id.fragListBook, BookListFragment(), BookListFragment::class.java.name).addToBackStack("bookListFrag").commit()




        // TODO replace BookListFragment in containerFrameLayout
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /*if(supportFragmentManager.findFragmentByTag("bookDetailFrag") != null){

            }*/
            supportFragmentManager.beginTransaction().replace(R.id.fragDetailBook, BookDetailFragment(), BookDetailFragment::class.java.name).addToBackStack("bookDetailFrag").commit()
        }else{
            supportFragmentManager.popBackStack("bookDetailFrag",FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }



    }


    override fun onBookSelect(b: Book) {
        Log.v("onBookSelect", "book title ==>"+b.title)

        val nextFrag = BookDetailFragment.newInstance(b, resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        actualBookDetailFrag = nextFrag
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            supportFragmentManager.popBackStack("bookListFrag", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragDetailBook, nextFrag, BookDetailFragment::class.java.name).addToBackStack("bookDetailFrag")
                .commit()
    }


    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        if(actualBookDetailFrag != null){
            supportFragmentManager.putFragment(outState!!,"savedDetailFrag", actualBookDetailFrag!!)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val fragment = supportFragmentManager.getFragment(savedInstanceState!!, "savedDetailFrag")
        if(fragment != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragDetailBook, fragment, BookDetailFragment::class.java.name).addToBackStack("bookDetailFrag").commit()
        }

    }



}
