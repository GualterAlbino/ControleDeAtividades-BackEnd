package br.com.ControleDeAtividades.application.projeto

import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoJDBCRepository
import br.com.ControleDeAtividades.application.projeto.exceptions.ProjetoNotFoundException

import org.springframework.stereotype.Service
import br.com.ControleDeAtividades.domain.projeto.Projeto
import java.util.UUID

@Service
class ProjetoService (
        private val projetoJDBCRepository: ProjetoJDBCRepository
) {
    fun inserir(projeto: ProjetoCreateCommand): Projeto? {
        val projetoDomain = projeto.toModel()
        projetoJDBCRepository.inserir(projeto = projetoDomain)
        return projetoJDBCRepository.buscarPorId(projetoDomain.id)
    }

    fun buscarTodos(): List<Projeto> {
        return projetoJDBCRepository.buscarTodos()
    }

    fun buscarPorId(projetoId: UUID): Projeto? {
        return projetoJDBCRepository.buscarPorId(projetoId)
    }

    fun deletar(projetoId: UUID): Boolean {
        return projetoJDBCRepository.deletar(projetoId)
    }

    fun atualizar(projeto: ProjetoUpdateComand, projetoId: UUID): Projeto? {
        projetoJDBCRepository.buscarPorId(projetoId) ?: ProjetoNotFoundException(projetoId = projetoId)
        projetoJDBCRepository.atualizar(projeto.toModel(id = projetoId))
        return projetoJDBCRepository.buscarPorId(projetoId)
    }
}