package br.com.ControleDeAtividades.application.atividade.exceptions

import java.util.*

sealed class AtividadeException (message: String): Exception(message) {
    abstract val atividadeId : UUID?
}

data class AtividadeNotFoundException (
        override val atividadeId: UUID?
): AtividadeException("Atividade ${atividadeId} não encotrado.")