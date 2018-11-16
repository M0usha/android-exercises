package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var loginLayout: ViewGroup
    lateinit var loggedText: View
    private lateinit var presenter: LoginPresenter
    private lateinit var passwordEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginLayout = findViewById(R.id.loginLayout)
        loggedText = findViewById(R.id.loggedText)
        passwordEdit = findViewById(R.id.passwordEdit)

        presenter = LoginPresenter(this)

        findViewById<View>(R.id.loginButton).setOnClickListener {
            presenter.checkCredentials(passwordEdit.text.toString())
        }

    }

    override fun onResume() {
        super.onResume()
        notLogged()
    }

    internal fun notLogged() {
        loginLayout.visibility = View.VISIBLE
        loggedText.visibility = View.GONE
    }

    internal fun logged() {
        loginLayout.visibility = View.GONE
        loggedText.visibility = View.VISIBLE
    }

    internal fun message(id: Int) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
    }
}
