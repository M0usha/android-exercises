package fr.android.androidexercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Step1Fragment : Fragment() {
    // TODO Override onCreateViewMethod

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_step1, container, false)



        return view
    }


}
