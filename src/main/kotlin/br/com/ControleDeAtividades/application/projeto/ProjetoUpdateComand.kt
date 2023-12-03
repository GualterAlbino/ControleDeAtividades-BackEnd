package br.com.ControleDeAtividades.application.projeto

import br.com.ControleDeAtividades.domain.projeto.Projeto
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class ProjetoUpdateComand (
        val cpf_coordenador: String,
        val nome: String,
        val objetivo: String,
        val recursos: String
)

fun ProjetoUpdateComand.toModel(id: UUID) = Projeto (
        id = id,
        cpf_coordenador = this.cpf_coordenador,
        nome = this.nome,
        objetivo = this.objetivo,
        recursos = this.recursos
)