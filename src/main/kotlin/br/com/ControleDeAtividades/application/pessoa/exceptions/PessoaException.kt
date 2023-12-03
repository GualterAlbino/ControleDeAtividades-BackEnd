package br.com.ControleDeAtividades.application.pessoa.exceptions


sealed class PessoaException(message: String): Exception(message) {
    abstract val cpf: String?
}

data class PessoaNaoEncontradoException(
        override val cpf: String? = null,
        val username: String? = null,
) : PessoaException("Dado ${cpf ?: username} não encontrado")

