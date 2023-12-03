package br.com.ControleDeAtividades.domain.atividade

import java.util.*

interface AtividadeRepository {
    fun inserir(atividade: Atividade): Boolean
    fun buscarTodos(): List<Atividade>
    fun buscarPorId(atividadeId: UUID): Atividade?
    fun deletar(atividadeId: UUID): Boolean
    fun atualizar(atividade: Atividade): Boolean
}