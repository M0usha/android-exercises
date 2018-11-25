package fr.android.nicolasf.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.android.nicolasf.R

class BookDetailFragment : Fragment() {
    // TODO Override onCreateViewMethod

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bookdetail, container, false)



        return view
    }


}
