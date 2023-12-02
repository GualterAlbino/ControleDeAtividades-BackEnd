package br.com.ControleDeAtividades.application.projeto.exceptions

import java.util.UUID

sealed class ProjetoException (message: String): Exception(message) {
    abstract val projetoId : UUID?
}

data class ProjetoNotFoundException (
        override val projetoId: UUID?
): ProjetoException("Projeto ${projetoId} não encotrado.")