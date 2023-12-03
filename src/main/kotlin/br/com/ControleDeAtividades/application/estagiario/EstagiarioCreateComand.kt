package br.com.ControleDeAtividades.application.estagiario

import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import kotlinx.serialization.Serializable

@Serializable
data class EstagiarioCreateCommand (
        val ra: Int,
        val cpf_pessoa: String,
        val periodo: String,
        val curso: String
)

fun EstagiarioCreateCommand.toModel() = Estagiario (
        ra = ra,
        cpf_pessoa = this.cpf_pessoa,
        periodo = this.periodo,
        curso = this.curso
)