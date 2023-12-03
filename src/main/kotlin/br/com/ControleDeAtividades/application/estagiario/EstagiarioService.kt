package br.com.ControleDeAtividades.application.estagiario

import br.com.ControleDeAtividades.adapters.jdbc.estagiario.EstagiarioJDBCRepository
import br.com.ControleDeAtividades.application.estagiario.exceptions.EstagiarioNotFoundException
import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import org.springframework.stereotype.Service

@Service
class EstagiarioService (
    private val estagiarioJDBCRepository: EstagiarioJDBCRepository
) {
    fun inserir(estagiario: EstagiarioCreateCommand): Estagiario? {
        val estagiarioDomain = estagiario.toModel()
        estagiarioJDBCRepository.inserir(estagiario = estagiarioDomain)
        return estagiarioJDBCRepository.buscarPorId(estagiarioDomain.ra)
    }

    fun buscarTodos(): List<Estagiario> {
        return estagiarioJDBCRepository.buscarTodos()
    }

    fun buscarPorId(estagiarioId: Int): Estagiario? {
        return estagiarioJDBCRepository.buscarPorId(estagiarioId)
    }

    fun deletar(estagiarioId: Int): Boolean {
        return estagiarioJDBCRepository.deletar(estagiarioId)
    }

    fun atualizar(estagiario: EstagiarioUpdateComand, estagiarioId: Int): Estagiario? {
        estagiarioJDBCRepository.buscarPorId(estagiarioId) ?: EstagiarioNotFoundException(estagiarioRa = estagiarioId)
        estagiarioJDBCRepository.atualizar(estagiario.toModel(ra = estagiarioId))
        return estagiarioJDBCRepository.buscarPorId(estagiarioId)
    }
}