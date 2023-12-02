package br.com.CarteiraDeInvestimentos.adapters.http.transacao

import br.com.CarteiraDeInvestimentos.application.usuario.TipoTrabalhoUpdateComand
import br.com.ControleDeAtividades.application.tipo_trabalho.TipoTrabalhoCreateComand

import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalho

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TipoTrabalhoController(
        private val tipoDeTrabalhoHandler: TipoTrabalhoHandler
) {
    @GetMapping("/tiposDeTrabalhos")
    fun buscarTodos(): ResponseEntity<List<TipoTrabalho>> {
        return tipoDeTrabalhoHandler.buscarTodos();
    }

    @GetMapping("/tiposDeTrabalhos/{transacaoId}") //:$UUID_REGEX
    fun buscarPorId(@PathVariable id: String): ResponseEntity<TipoTrabalho> {
        return tipoDeTrabalhoHandler.buscarPorId(id)
    }

    @PostMapping("/tiposDeTrabalhos")
    fun inserir(@RequestBody transacao: TipoTrabalhoCreateComand): ResponseEntity<TipoTrabalho> {

        return tipoDeTrabalhoHandler.inserir(transacao)
    }

    @DeleteMapping("/tiposDeTrabalhos/{transacaoId}")
    fun excluir(@PathVariable transacaoId: String): ResponseEntity<String> {
        return tipoDeTrabalhoHandler.excluir(transacaoId)
    }

    @PatchMapping("/tiposDeTrabalhos/{transacaoId}")
    fun atualizar(@RequestBody transacao: TipoTrabalhoUpdateComand, @PathVariable id: String): ResponseEntity<TipoTrabalho> {
        return tipoDeTrabalhoHandler.atualizar(transacao, id)
    }

}