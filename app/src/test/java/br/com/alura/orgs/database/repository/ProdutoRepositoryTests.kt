package br.com.alura.orgs.database.repository

import android.database.sqlite.SQLiteOpenHelper
import br.com.alura.orgs.database.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.math.BigDecimal

class ProdutoRepositoryTests {

    @Test
    fun salva() = runTest{
        // Arrange
        val mockSQLiteOpenHelper = mockk<SQLiteOpenHelper>()

        // Simula o comportamento do método getWritableDatabase
        every { mockSQLiteOpenHelper.getWritableDatabase() } returns mockk()

        // Simule a criação do dao usando a instância do mockSQLiteOpenHelper
        val dao = mockk<ProdutoDao>()
        coEvery {
            dao.salva(any())
        } returns Unit

        // Crie uma instância do produtoRepository usando o dao simulado
        val produtoRepository = ProdutoRepository(dao)
        val produto = Produto(
            nome = "Uva",
            descricao = "Uva verde sem caroço",
            valor = BigDecimal("8.99")
        )

        // Act
        produtoRepository.salva(produto)

        // Verify
        coVerify {
            dao.salva(produto)
        }
    }
}