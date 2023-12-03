package br.com.ControleDeAtividades.application.atividade

import br.com.ControleDeAtividades.domain.atividade.Atividade
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class AtividadeCreateComand (
        val id_tipo_trabalho : UUID,
        val id_historico : UUID,
        val descricao : String,
        val finalizada : Boolean,
        val cpf_professor_responsavel : String
)

fun AtividadeCreateComand.toModel() = Atividade (
        id_tipo_trabalho = id_tipo_trabalho,
        id_historico = id_historico,
        descricao = descricao,
        finalizada = finalizada,
        cpf_professor_responsavel = cpf_professor_responsavel
)