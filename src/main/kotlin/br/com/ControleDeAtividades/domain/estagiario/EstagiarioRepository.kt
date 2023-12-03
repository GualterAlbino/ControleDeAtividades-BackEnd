package br.com.ControleDeAtividades.domain.estagiario

import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import br.com.ControleDeAtividades.domain.projeto.Projeto
import java.util.*

interface EstagiarioRepository {
    fun inserir(estagiario: Estagiario, cpf:Pessoa): Boolean
    fun buscarTodos(): List<Estagiario>
    fun buscarPorId(estagiarioRa: String): Estagiario?
    fun deletar(estagiarioRa: String): Boolean
    fun atualizar(estagiario: Estagiario): Boolean
}