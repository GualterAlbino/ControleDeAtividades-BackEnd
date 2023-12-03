package br.com.ControleDeAtividades.application.atividade

import br.com.ControleDeAtividades.adapters.jdbc.atividade.AtividadeJDBCRepository
import br.com.ControleDeAtividades.application.atividade.exceptions.AtividadeNotFoundException
import br.com.ControleDeAtividades.domain.atividade.Atividade
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AtividadeService (
        private val atividadeJDBCRepository: AtividadeJDBCRepository
) {
    fun inserir(atividade: AtividadeCreateComand): Atividade? {
        val atividadeDomain = atividade.toModel()
        atividadeJDBCRepository.inserir(atividade = atividadeDomain)
        return atividadeJDBCRepository.buscarPorId(atividadeDomain.id)
    }

    fun buscarTodos(): List<Atividade> {
        return atividadeJDBCRepository.buscarTodos()
    }

    fun buscarPorId(atividadeId: UUID): Atividade? {
        return atividadeJDBCRepository.buscarPorId(atividadeId)
    }

    fun deletar(atividadeId: UUID): Boolean {
        return atividadeJDBCRepository.deletar(atividadeId)
    }

    fun atualizar(atividade: AtividadeUpdateComand, atividadeId: UUID): Atividade? {
        atividadeJDBCRepository.buscarPorId(atividadeId) ?: AtividadeNotFoundException(atividadeId = atividadeId)
        atividadeJDBCRepository.atualizar(atividade.toModel(id = atividadeId))
        return atividadeJDBCRepository.buscarPorId(atividadeId)
    }

}