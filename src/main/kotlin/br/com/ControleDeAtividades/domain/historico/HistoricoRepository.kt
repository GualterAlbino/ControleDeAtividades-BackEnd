package br.com.ControleDeAtividades.domain.historico

import br.com.ControleDeAtividades.domain.atividade.Atividade
import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import br.com.ControleDeAtividades.domain.pessoa.Pessoa

interface HistoricoRepository {
    fun inserir(historico: Historico): Boolean
    fun buscarTodosPorAtividade(atividadeId: Atividade): List<Historico>
    fun buscarTodos(): List<Historico>
    fun buscarPorId(historicoId: String): Historico?
    fun deletar(historicoId: String): Boolean
    fun atualizar(historico: Historico): Boolean
}