package fr.android.androidexercises

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class BookAdapter(context: Context, private val books: List<Book>) : BaseAdapter() {


    private var inflater: LayoutInflater

    init {
        // TODO LayoutInflater.from()
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return books.count()
    }

    override fun getItem(position: Int): Book {
        return books[position]
    }

    override fun getItemId(position: Int): Long {
        return books[position].hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.custom_view_item_book, parent, false)
        }
        val book = getItem(position)
        val bookItemView = view as BookItemView
        bookItemView.bindView(book)
        return bookItemView
    }

}
