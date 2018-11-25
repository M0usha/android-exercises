package fr.android.nicolasf.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.android.nicolasf.R
import fr.android.nicolasf.book.Book
import org.w3c.dom.Text


class BookDetailFragment : Fragment() {

    private var book: Book? = null
    private var orientationLandscape: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            book = it.getParcelable("book")
            orientationLandscape = it.getBoolean("orientationLandscape")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bookdetail, container, false)

        val titleDetailTextView = view.findViewById<TextView>(R.id.titleDetailTextView)
        val coverDetailImageView = view.findViewById<ImageView>(R.id.coverDetailImageView)
        val synopsisDetailTextView = view.findViewById<TextView>(R.id.synopsisDetailTextView)

        if(book != null){
            titleDetailTextView.text = book!!.title
            Picasso.get().load(book!!.cover).into(coverDetailImageView)
            var textSynopsis = ""
            book!!.synopsis.forEach {
                textSynopsis += it
                textSynopsis += "\n"
            }
            synopsisDetailTextView.text = textSynopsis
        }


        return view
    }



    companion object {

        @JvmStatic
        fun newInstance(book: Book, orientationLandscape: Boolean) = BookDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("book", book)
                putBoolean("orientationLandscape", orientationLandscape)
            }
        }
    }


}
