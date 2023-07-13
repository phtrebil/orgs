package br.com.alura.orgs.ui.activity

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.alura.orgs.R
import org.junit.Test

class LoginActivityTests{

    @Test
    fun deveMostrarCamposNecessariosParaFazerOLogin(){
        launch(LoginActivity::class.java)
        onView(withId(R.id.activity_login_usuario))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_login_senha))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_login_botao_cadastrar))
    }
}