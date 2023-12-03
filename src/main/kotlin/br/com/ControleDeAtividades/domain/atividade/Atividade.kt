package br.com.ControleDeAtividades.domain.atividade

import java.util.UUID

data class Atividade (
        val id : UUID = UUID.randomUUID(),
        val id_tipo_trabalho : UUID,
        val id_historico : UUID,
        val descricao : String,
        val finalizada : Boolean,
        val cpf_professor_responsavel : String
)
