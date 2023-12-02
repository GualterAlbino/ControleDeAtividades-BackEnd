package br.com.ControleDeAtividades.adapters.http.pessoa

import br.com.ControleDeAtividades.application.pessoa.PessoaCreateComand
import br.com.ControleDeAtividades.application.pessoa.PessoaService
import br.com.ControleDeAtividades.application.pessoa.PessoaUpdateComand
import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class PessoaHandler(
        private val pessoaService: PessoaService
) {
    fun findAll(): ResponseEntity<List<Pessoa>> {
        val transacoes = pessoaService.findAll()
        return ResponseEntity.ok(transacoes)
    }

    fun findByCpf(cpf: String): ResponseEntity<Pessoa> {

        val transacaoProcurada = pessoaService.findByCpf(cpf)

        return ResponseEntity.ok(transacaoProcurada)
    }

    fun inserir(transacaoCreateComand: PessoaCreateComand): ResponseEntity<Pessoa> {
        val transacao = pessoaService.inserir(transacaoCreateComand)
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao)
    }

    fun excluir(cpf : String): ResponseEntity<String> {
        pessoaService.excluir(cpf)
        return ResponseEntity.noContent().build()
    }

    fun atualizar(transacaoUpdateComand: PessoaUpdateComand, cpf: String): ResponseEntity<Pessoa> {
        val transacao = pessoaService.atualizar(transacaoUpdateComand, cpf)
        return ResponseEntity.ok(transacao)
    }
}