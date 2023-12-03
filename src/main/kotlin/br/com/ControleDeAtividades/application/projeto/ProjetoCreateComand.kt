package br.com.ControleDeAtividades.application.projeto

import br.com.ControleDeAtividades.domain.projeto.Projeto
import kotlinx.serialization.Serializable

@Serializable
data class ProjetoCreateCommand (
        val cpf_coordenador: String,
        val nome: String,
        val objetivo: String,
        val recursos: String
)

fun ProjetoCreateCommand.toModel() = Projeto (
        cpf_coordenador = this.cpf_coordenador,
        nome = this.nome,
        objetivo = this.objetivo,
        recursos = this.recursos
)