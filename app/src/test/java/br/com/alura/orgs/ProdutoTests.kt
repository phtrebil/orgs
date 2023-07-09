package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTests {
    @Test
    fun `Should retorna verdadeiro When for valido`(){
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorEhValido = produtoValido.valorEhValido

        valorEhValido.shouldBeTrue()


    }

    @Test
    fun `Should retornar Falso When for Maior Que Cem`() {
        //Arrange - Arrumar
        val produtoInvalido = Produto(
            nome = "Carambola",
            descricao = "Amarela",
            valor = BigDecimal("105.99")
        )

        //Act - Agir
        val valorEhValido = produtoInvalido.valorEhValido

        //Assert - Afirme
        valorEhValido.shouldBeFalse()
    }

    @Test
    fun `Should retorna Falso When for Igual Ou Menor Que Zero`() {
        val produtoComValorIgualAZero = Produto(
            nome = "Lichia",
            descricao = "Doce",
            valor = BigDecimal("0")
        )
        val produtoComValorMenorQueZero = Produto(
            nome = "Uva",
            descricao = "Thompson",
            valor = BigDecimal("-10.99")
        )

        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorEhValido
        val valorMenorQueZeroEhValido = produtoComValorMenorQueZero.valorEhValido

        valorIgualAZeroEhValido.shouldBeFalse()
        valorMenorQueZeroEhValido.shouldBeFalse()
    }

}