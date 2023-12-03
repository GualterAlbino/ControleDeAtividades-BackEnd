package br.com.ControleDeAtividades.adapters.http.projeto

import br.com.ControleDeAtividades.application.projeto.ProjetoCreateCommand
import br.com.ControleDeAtividades.application.projeto.ProjetoService
import br.com.ControleDeAtividades.application.projeto.ProjetoUpdateComand
import br.com.ControleDeAtividades.domain.projeto.Projeto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class ProjetoHandler (
        private val projetoService: ProjetoService
) {
    fun inserir(projetoCreateCommand: ProjetoCreateCommand): ResponseEntity<Projeto> {
        val projeto = projetoService.inserir(projetoCreateCommand)
        return ResponseEntity.status(HttpStatus.CREATED).body(projeto)
    }

    fun buscarTodos(): ResponseEntity<List<Projeto>> {
        val projetos = projetoService.buscarTodos()
        return ResponseEntity.ok(projetos)
    }

    fun buscarPorId(projetoId: String): ResponseEntity<Projeto> {
        val projeto = projetoService.buscarPorId(UUID.fromString(projetoId))
        return ResponseEntity.ok(projeto)
    }

    fun atualizar(projetoUpdateComand: ProjetoUpdateComand, projetoId: String): ResponseEntity<Projeto> {
        val projeto = projetoService.atualizar(projetoUpdateComand, UUID.fromString(projetoId))
        return ResponseEntity.ok(projeto)
    }

    fun deletar(projetoId: String): ResponseEntity<Boolean> {
        val projeto = projetoService.deletar(UUID.fromString(projetoId))
        return ResponseEntity.ok(projeto)
    }
}