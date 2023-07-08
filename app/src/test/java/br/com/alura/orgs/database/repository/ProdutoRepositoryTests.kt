package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.AppDatabase
import br.com.alura.orgs.model.Produto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.math.BigDecimal

class ProdutoRepositoryTests {

    @Test
    fun salva() = runTest {
        // Arrange
        val context = mockk<android.content.Context>()
        val dao = AppDatabase.instancia(context).produtoDao()
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome = "Uva",
            descricao = "Uva verde sem caroço",
            valor = BigDecimal("8.99")
        )

        // Act
        coEvery  {
            dao.salva(produto)
        }.returns(Unit)

        // Act
        produtoRepository.salva(produto)

        // Verify
         coVerify {
            dao.salva(produto)
        }
    }
}
