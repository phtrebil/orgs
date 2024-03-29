package br.com.alura.orgs

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.ui.activity.FormularioProdutoActivity
import br.com.alura.orgs.ui.activity.ListaProdutosActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProdutoTelasTest {

    @get:Rule
    val rule = ActivityScenarioRule(ListaProdutosActivity::class.java)

    @Before fun preparaAmbiente(){
        AppDatabase.instancia(InstrumentationRegistry.getInstrumentation().targetContext).clearAllTables()
    }
    @Test
    fun deveMostrarCamposNecessarioParaCriarUmProduto() {

        clicaNoFab()

        onView(withId(R.id.activity_formulario_produto_nome)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_descricao)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_valor)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_formulario_produto_botao_salvar)).check(matches(isDisplayed()))
    }

    @Test
    fun deveSerCapazDePreencherOsCamposESalvar() {

        clicaNoFab()
        preencheCamposDoFormulario("Banana", "Banana Prata", "6.99")
        clicaEmSalvar()

        checaProduto("Banana")

    }

    private fun checaProduto(nome: String) {
        onView(withText(nome)).check(matches(isDisplayed()))
    }

    private fun preencheCamposDoFormulario(nome:String, descricao:String, valor: String) {
        onView(withId(R.id.activity_formulario_produto_nome))
            .perform(
                replaceText(nome),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_produto_descricao))
            .perform(
                replaceText(descricao),
                closeSoftKeyboard()
            )
        onView(withId(R.id.activity_formulario_produto_valor))
            .perform(
                replaceText(valor),
                closeSoftKeyboard()
            )
    }

    private fun clicaNoFab() {
        onView(withId(R.id.activity_lista_produtos_fab)).perform(click())
    }

    @Test
    fun deveSerCapazDeEditarUmProduto(){
        deveSerCapazDePreencherOsCamposESalvar()

        onView(withText("Banana")).perform(click())

        onView(withId(R.id.menu_detalhes_produto_editar)).perform(click())

        preencheCamposDoFormulario("Limao", "Limao Siciliano", "8.99")

        clicaEmSalvar()

        checaProduto("Limao")

        Espresso.pressBack()

    }

    private fun clicaEmSalvar() {
        onView(withId(R.id.activity_formulario_produto_botao_salvar))
            .perform(click())
    }
}