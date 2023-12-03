package br.com.ControleDeAtividades.domain.pessoa

import java.util.*

interface PessoaRepository {

    fun findAll(): List<Pessoa>

    fun findByCpf(cpf: String):Pessoa?

    fun inserir(pessoa: Pessoa): Boolean

    fun excluir(cpf: String):Boolean

    fun atualizar(pessoa: Pessoa):Boolean
}