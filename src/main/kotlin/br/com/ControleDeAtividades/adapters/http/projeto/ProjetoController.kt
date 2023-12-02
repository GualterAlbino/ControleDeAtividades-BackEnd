package br.com.ControleDeAtividades.adapters.http.projeto

import br.com.ControleDeAtividades.application.projeto.ProjetoCreateCommand
import br.com.ControleDeAtividades.application.projeto.ProjetoUpdateComand
import br.com.ControleDeAtividades.domain.projeto.Projeto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.Objects

@RestController
class ProjetoController (
   private val projetoHandler: ProjetoHandler
) {
    @PostMapping("/projeto")
    fun inserir(@RequestBody projetoCreateCommand: ProjetoCreateCommand): ResponseEntity<Projeto> {
        return projetoHandler.inserir(projetoCreateCommand)
    }

    @GetMapping("/projetos")
    fun buscarTodos(): ResponseEntity<List<Projeto>> {
        return projetoHandler.buscarTodos()
    }

    @GetMapping("/projeto/{projetoId}")
    fun buscarPorId(@PathVariable projetoId: String): ResponseEntity<Projeto> {
        return projetoHandler.buscarPorId(projetoId)
    }

    @PutMapping("/projeto/{projetoId}")
    fun atualizar(@RequestBody projetoUpdateCommand: ProjetoUpdateComand,@PathVariable("projetoId") projetoId: String): ResponseEntity<Projeto> {
        return projetoHandler.atualizar(projetoUpdateCommand, projetoId)
    }

    @DeleteMapping("/projeto/{projetoId}")
    fun deletar (@PathVariable projetoId: String): ResponseEntity<String> {
        projetoHandler.deletar(projetoId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}