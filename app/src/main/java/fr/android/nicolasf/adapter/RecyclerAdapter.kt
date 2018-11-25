package fr.android.nicolasf.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.android.nicolasf.R
import fr.android.nicolasf.book.Book

class RecyclerAdapter(context: Context?, val books: Array<Book>?, val onBookPressed: (b: Book) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder =
            MyViewHolder(inflater.inflate(R.layout.custom_view_item_book, parent, false))

    override fun getItemCount(): Int = books!!.size

    override fun onBindViewHolder(p0: MyViewHolder, position: Int) {
        val view = p0.itemView

        val titleView = p0.itemView.findViewById<TextView>(R.id.nameTextView)
        val coverView = p0.itemView.findViewById<ImageView>(R.id.coverImageView)

        titleView.text = books!![position].title
        Picasso.get().load(books!![position].cover).into(coverView)

        p0.itemView.setOnClickListener { onBookPressed(books[position]) }


    }


    private val inflater : LayoutInflater = LayoutInflater.from(context)

}

class MyViewHolder(v: View): RecyclerView.ViewHolder(v)
