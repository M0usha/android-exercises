package fr.android.androidexercises

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class LoginPresenterTest {

    @RelaxedMockK
    private lateinit var activity: LoginActivity
    private lateinit var presenter: LoginPresenter
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        presenter = LoginPresenter(activity)
    }


    // TODO test login presenter with JUnit and MockK
    @Test
    fun password_valid(){
        presenter.checkCredentials("password")
        verify {
            activity.logged()
            activity.message(R.string.text_logged)
        }
    }

    @Test
    fun password_null(){
        presenter.checkCredentials(null)
        verify {
            activity.notLogged()
            activity.message(R.string.notLogged)
        }
    }

    @Test
    fun password_short(){
        presenter.checkCredentials("1")
        verify {
            activity.notLogged()
            activity.message(R.string.notLogged)
        }
    }
}

