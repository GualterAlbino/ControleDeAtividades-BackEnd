package br.com.ControleDeAtividades.adapters.http.estagiario

import br.com.ControleDeAtividades.application.estagiario.EstagiarioCreateCommand
import br.com.ControleDeAtividades.application.estagiario.EstagiarioUpdateComand
import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EstagiarioController (
        private val estagiarioHandler: EstagiarioHandler
) {
    @PostMapping("/estagiario")
    fun inserir(@RequestBody estagiarioCreateCommand: EstagiarioCreateCommand): ResponseEntity<Estagiario> {
        return estagiarioHandler.inserir(estagiarioCreateCommand)
    }

    @GetMapping("/estagiarios")
    fun buscarTodos(): ResponseEntity<List<Estagiario>> {
        return estagiarioHandler.buscarTodos()
    }

    @GetMapping("/estagiario/{estagiarioId}")
    fun buscarPorId(@PathVariable estagiarioId: Int): ResponseEntity<Estagiario> {
        return estagiarioHandler.buscarPorId(estagiarioId)
    }

    @PutMapping("/estagiario/{estagiarioId}")
    fun atualizar(@RequestBody estagiarioUpdateCommand: EstagiarioUpdateComand,@PathVariable("estagiarioId") estagiarioId: Int): ResponseEntity<Estagiario> {
        return estagiarioHandler.atualizar(estagiarioUpdateCommand, estagiarioId)
    }

    @DeleteMapping("/estagiario/{estagiarioId}")
    fun deletar (@PathVariable estagiarioId: Int): ResponseEntity<Boolean> {
        return estagiarioHandler.deletar(estagiarioId)
    }
}