package br.com.ControleDeAtividades.application.pessoa

import br.com.ControleDeAtividades.application.pessoa.exceptions.PessoaNaoEncontradoException
import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import br.com.ControleDeAtividades.domain.pessoa.PessoaRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class PessoaService(
        private val pessoaRepository: PessoaRepository
) {

    fun findAll(): List<Pessoa>{
        return pessoaRepository.findAll()
    }

    fun findByCpf(cpf: String): Pessoa? {
        return pessoaRepository.findByCpf(cpf)
    }

    fun inserir(pessoa: PessoaCreateComand): Pessoa? {

        val pessoaDomain = pessoa.toPessoa()

        pessoaRepository.inserir(pessoa = pessoaDomain)

        if (pessoaDomain != null) {
            return findByCpf(pessoaDomain.cpf)
        }
        return null
    }

    fun excluir(cpf: String) {
        pessoaRepository.findByCpf(cpf= cpf) ?: throw  PessoaNaoEncontradoException(cpf)

        pessoaRepository.excluir(cpf)
    }

    fun atualizar(pessoa: PessoaUpdateComand, cpf: String):Pessoa? {
        pessoaRepository.findByCpf(cpf)?: throw  PessoaNaoEncontradoException(cpf)
        pessoaRepository.atualizar(pessoa.toPessoa())

        return findByCpf(cpf = cpf)
    }
}