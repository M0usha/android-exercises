package fr.android.nicolasf.book

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import fr.android.nicolasf.R

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    var titleView: TextView? = null
    var priceView: TextView? = null
    var coverView: ImageView? = null
    var isbnView: TextView? = null


    override fun onFinishInflate() {
        super.onFinishInflate()
        // TODO findViewById()
        titleView = findViewById(R.id.nameTextView)
        priceView = findViewById(R.id.priceTextView)
        isbnView = findViewById(R.id.isbnTextView)
        coverView = findViewById(R.id.coverImageView)

    }

    fun bindView(book: Book) {
        // TODO setText()
        isbnView?.text = book.isbn
        coverView?.image
        titleView?.text = book.title
        priceView?.text = book.price.toString()
    }
}