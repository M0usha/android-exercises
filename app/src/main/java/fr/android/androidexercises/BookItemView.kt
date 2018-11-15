package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    var titleView: TextView? = null
    var priveView: TextView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        // TODO findViewById()
        titleView = findViewById(R.id.nameTextView)
        priveView = findViewById(R.id.priceTextView)

    }

    fun bindView(book: Book) {
        // TODO setText()
        titleView?.text = book.name
        priveView?.text = book.price.toString()
    }
}
