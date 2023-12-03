package br.com.ControleDeAtividades.adapters.http.estagiario

import br.com.ControleDeAtividades.application.estagiario.EstagiarioCreateCommand
import br.com.ControleDeAtividades.application.estagiario.EstagiarioService
import br.com.ControleDeAtividades.application.estagiario.EstagiarioUpdateComand
import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class EstagiarioHandler (
        private val estagiarioService: EstagiarioService
) {
    fun inserir(estagiarioCreateCommand: EstagiarioCreateCommand): ResponseEntity<Estagiario> {
        val estagiario = estagiarioService.inserir(estagiarioCreateCommand)
        return ResponseEntity.status(HttpStatus.CREATED).body(estagiario)
    }

    fun buscarTodos(): ResponseEntity<List<Estagiario>> {
        val estagiarios = estagiarioService.buscarTodos()
        return ResponseEntity.ok(estagiarios)
    }

    fun buscarPorId(estagiarioId: Int): ResponseEntity<Estagiario> {
        val estagiario = estagiarioService.buscarPorId(estagiarioId)
        return ResponseEntity.ok(estagiario)
    }

    fun atualizar(estagiarioUpdateComand: EstagiarioUpdateComand, estagiarioId: Int): ResponseEntity<Estagiario> {
        val estagiario = estagiarioService.atualizar(estagiarioUpdateComand, estagiarioId)
        return ResponseEntity.ok(estagiario)
    }

    fun deletar(estagiarioId: Int): ResponseEntity<Boolean> {
        val estagiario = estagiarioService.deletar(estagiarioId)
        return ResponseEntity.ok(estagiario)
    }
}