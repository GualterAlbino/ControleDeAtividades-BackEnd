package br.com.ControleDeAtividades.domain.estagiario

import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import br.com.ControleDeAtividades.domain.projeto.Projeto
import java.util.*

interface EstagiarioRepository {
    fun inserir(estagiario: Estagiario): Boolean
    fun buscarTodos(): List<Estagiario>
    fun buscarPorId(estagiarioRa: Int): Estagiario?
    fun deletar(estagiarioRa: Int): Boolean
    fun atualizar(estagiario: Estagiario): Boolean
}