package br.com.alura.orgs.ui.activity

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import br.com.alura.orgs.R
import org.junit.Test

class FormularioCadastroUsuarioActivityTests{
    @Test
    fun deveMostrarCamposNecessariosParaFazerOCadastro(){
        launch(FormularioCadastroUsuarioActivity::class.java)
        onView(withId(R.id.activity_formulario_cadastro_usuario))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_nome))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_senha))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun devePreencherOsCamposNecessariosParaFazerOCadastro(){
        launch(FormularioCadastroUsuarioActivity::class.java)
        onView(withId(R.id.activity_formulario_cadastro_usuario))
            .perform(ViewActions.typeText("phtrebil"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_cadastro_nome))
            .perform(ViewActions.typeText("Pedro Trebilcock"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_cadastro_senha))
            .perform(ViewActions.typeText("1234"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_cadastro_botao_cadastrar))
            .perform(ViewActions.click())
    }
}