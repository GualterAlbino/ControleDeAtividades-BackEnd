package br.com.ControleDeAtividades.application.estagiario

import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import kotlinx.serialization.Serializable

@Serializable
data class EstagiarioUpdateComand (
        val cpf_pessoa: String,
        val periodo: String,
        val curso: String
)

fun EstagiarioUpdateComand.toModel(ra: Int) = Estagiario (
        ra = ra,
        cpf_pessoa = this.cpf_pessoa,
        periodo = this.periodo,
        curso = this.curso
)