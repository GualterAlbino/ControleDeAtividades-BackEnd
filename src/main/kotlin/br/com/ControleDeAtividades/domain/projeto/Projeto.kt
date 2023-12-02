package br.com.ControleDeAtividades.domain.projeto

import java.util.UUID

data class Projeto (
    val id: UUID = UUID.randomUUID(),
    val cpf_coordenador: String,
    val nome: String,
    val objetivo: String,
    val recursos: String
)