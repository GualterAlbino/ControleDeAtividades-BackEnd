package br.com.ControleDeAtividades.application.tipo_trabalho.exceptions

import java.util.*


//Super Classe que sera usada para implementação das demais
sealed class TipoTrabalhoException(message: String): Exception(message) {
    abstract val id: UUID?
    abstract val descricao: String?
}

data class TipoTrabalhoNaoEncontradoException(
        override val id: UUID? = null,
        override val descricao: String? = null,
) : TipoTrabalhoException("Informação:  ${id ?: descricao} não encontrada!")