package br.com.ControleDeAtividades.domain.historico

import java.util.UUID

data class Historico (
    val id : UUID= UUID.randomUUID(),
    val data_hora_saida : String,
    val data_hora_entrada: String
)