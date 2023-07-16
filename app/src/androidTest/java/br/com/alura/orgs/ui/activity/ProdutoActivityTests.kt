package br.com.alura.orgs.ui.activity

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.alura.orgs.R
import org.junit.Test

class ProdutoActivityTests {

    @Test
    fun deveMostrarONomeDoAplicativo(){
        launch(ListaProdutosActivity::class.java)
        onView(withText("Orgs")).check(matches(isDisplayed()))
    }

    @Test
    fun deveMostrarCamposNecessariosParaCriarumProduto(){
        launch(FormularioProdutoActivity::class.java)
        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
    }

    @Test fun deveSerCapazDePreencherFormularioESalvar(){
        launch(FormularioProdutoActivity::class.java)
        onView(withId(R.id.activity_formulario_produto_nome)).perform(ViewActions.typeText("Banana"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_produto_descricao)).perform(ViewActions.typeText("Banana Prata"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_produto_valor)).perform(ViewActions.typeText("6.99"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).perform(ViewActions.click())

        launch(ListaProdutosActivity::class.java)
        onView((withText("Banana"))).check(matches(isDisplayed()))

    }
}