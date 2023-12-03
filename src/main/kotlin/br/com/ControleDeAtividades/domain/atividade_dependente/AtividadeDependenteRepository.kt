package br.com.ControleDeAtividades.domain.atividade_dependente

import br.com.ControleDeAtividades.domain.atividade.Atividade
import java.util.*

interface AtividadeDependenteRepository {
    fun inserir(atividadeDependente: AtividadeDependente): Boolean
    fun buscarTodos(): List<AtividadeDependente>
    fun buscarAtividadesDependentes(atividade_principal_id: UUID): List<AtividadeDependente>?
    fun deletarAtividadePrincipal(atividade_principal_id: UUID): Boolean
    fun deletar(atividadeDependente: AtividadeDependente)
    fun atualizar(atividadeDependente: AtividadeDependente): Boolean
}
