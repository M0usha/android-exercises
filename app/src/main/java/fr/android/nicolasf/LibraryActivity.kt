package fr.android.nicolasf

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LibraryActivity : AppCompatActivity(), Step0Fragment.OnNextStep0Listener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)


        supportFragmentManager.beginTransaction().replace(R.id.containerFrameLayout, Step0Fragment(), Step0Fragment::class.java.name).commit()
        // TODO replace Step0Fragment in containerFrameLayout
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction().replace(R.id.containerFrameLayout2, Step1Fragment(), Step1Fragment::class.java.name).commit()
        }



    }


    override fun onNext() {
        // TODO implement onNext() from Step0Fragment.OnNextStep0Listener

        supportFragmentManager.beginTransaction().replace(R.id.containerFrameLayout, Step1Fragment(), Step1Fragment::class.java.name).addToBackStack(Step0Fragment::class.java.name).commit()

    }




}
