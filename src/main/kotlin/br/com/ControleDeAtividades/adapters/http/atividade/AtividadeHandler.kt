package br.com.ControleDeAtividades.adapters.http.atividade

import br.com.ControleDeAtividades.application.atividade.AtividadeCreateComand
import br.com.ControleDeAtividades.application.atividade.AtividadeService
import br.com.ControleDeAtividades.application.atividade.AtividadeUpdateComand
import br.com.ControleDeAtividades.domain.atividade.Atividade
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AtividadeHandler (
        private val atividadeService: AtividadeService
) {
    fun inserir(atividadeCreateComand: AtividadeCreateComand): ResponseEntity<Atividade> {
        val atividade = atividadeService.inserir(atividadeCreateComand)
        return ResponseEntity.status(HttpStatus.CREATED).body(atividade)
    }

    fun buscarTodos(): ResponseEntity<List<Atividade>> {
        val atividades = atividadeService.buscarTodos()
        return ResponseEntity.ok(atividades)
    }

    fun buscarPorId(atividadeId: String): ResponseEntity<Atividade> {
        val atividade = atividadeService.buscarPorId(UUID.fromString(atividadeId))
        return ResponseEntity.ok(atividade)
    }

    fun atualizar(atividadeUpdateComand: AtividadeUpdateComand, atividadeId: String): ResponseEntity<Atividade> {
        val atividade = atividadeService.atualizar(atividadeUpdateComand, UUID.fromString(atividadeId))
        return ResponseEntity.ok(atividade)
    }

    fun deletar(atividadeId: String): ResponseEntity<Boolean> {
        val atividade = atividadeService.deletar(UUID.fromString(atividadeId))
        return ResponseEntity.ok(atividade)
    }
}