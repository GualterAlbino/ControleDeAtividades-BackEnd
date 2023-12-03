package br.com.ControleDeAtividades.domain.atividade_dependente

import java.util.UUID

data class AtividadeDependente (
    val atividade_principal_id : UUID,
    val atividade_dependente_id : UUID
)