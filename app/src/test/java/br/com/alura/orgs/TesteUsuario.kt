package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.amshove.kluent.`should be equal to`
import org.junit.Assert
import org.junit.Test


class UsuarioTests {

    @Test
    fun `Should retorna Verdadeiro When Os Dados Do Usuario Estao Certos`() {
        val usuarioValido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioValido.ehValido()

        resultado `should be equal to` true
    }


    @Test
    fun `Should retorna Falso When A Senha Do Usuario Estiver Errada Com Menos De 6 Caracteres`() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "fraca"
        )

        val resultado = usuarioInvalido.ehValido()

        resultado `should be equal to` false
    }
}