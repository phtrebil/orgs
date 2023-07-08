package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.model.Produto
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.manipulation.Ordering.Context
import java.math.BigDecimal

class ProdutoRepositoryTests {

    @Test
    fun salva() {
        //Arrange
        val context = mockk<android.content.Context>()
        val dao = AppDatabase.instancia(context).produtoDao()
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome= "Uva",
        descricao = "Uva verde sem caroço",
            valor = BigDecimal("8.99")
            )

        //Act
        produtoRepository.salva(produto)

        verify {
            dao.salva(produto)
        }

    }
}