package br.com.ControleDeAtividades.domain.projeto

import java.util.*

interface ProjetoRepository {
    fun inserir(projeto: Projeto): Boolean
    fun buscarTodos(): List<Projeto>
    fun buscarPorId(projetoId: UUID): Projeto?
    fun deletar(projetoId: UUID): Boolean
    fun atualizar(projeto: Projeto): Boolean
}