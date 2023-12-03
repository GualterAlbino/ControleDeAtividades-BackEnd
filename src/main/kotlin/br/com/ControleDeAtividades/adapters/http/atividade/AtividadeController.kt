package br.com.ControleDeAtividades.adapters.http.atividade

import br.com.ControleDeAtividades.application.atividade.AtividadeCreateComand
import br.com.ControleDeAtividades.application.atividade.AtividadeUpdateComand
import br.com.ControleDeAtividades.domain.atividade.Atividade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AtividadeController (
        private val atividadeHandler: AtividadeHandler
) {
    @PostMapping("/atividade")
    fun inserir(@RequestBody atividadeCreateCommand: AtividadeCreateComand): ResponseEntity<Atividade> {
        return atividadeHandler.inserir(atividadeCreateCommand)
    }

    @GetMapping("/atividades")
    fun buscarTodos(): ResponseEntity<List<Atividade>> {
        return atividadeHandler.buscarTodos()
    }

    @GetMapping("/atividade/{atividadeId}")
    fun buscarPorId(@PathVariable atividadeId: String): ResponseEntity<Atividade> {
        return atividadeHandler.buscarPorId(atividadeId)
    }

    @PutMapping("/atividade/{atividadeId}")
    fun atualizar(@RequestBody atividadeUpdateCommand: AtividadeUpdateComand, @PathVariable("atividadeId") atividadeId: String): ResponseEntity<Atividade> {
        return atividadeHandler.atualizar(atividadeUpdateCommand, atividadeId)
    }

    @DeleteMapping("/atividade/{atividadeId}")
    fun deletar (@PathVariable atividadeId: String): ResponseEntity<String> {
        atividadeHandler.deletar(atividadeId)
        return ResponseEntity.ok("Atividade deletada com sucesso!")
    }
}