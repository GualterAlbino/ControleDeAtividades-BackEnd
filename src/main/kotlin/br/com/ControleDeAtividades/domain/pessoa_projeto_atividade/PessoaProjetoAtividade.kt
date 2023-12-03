package br.com.ControleDeAtividades.domain.pessoa_projeto_atividade

import java.util.UUID

data class PessoaProjetoAtividade (
    val cpf_pessoa: String,
    val projeto_id: UUID,
    val atividade_id: UUID,
    val horas_trab: String
)
