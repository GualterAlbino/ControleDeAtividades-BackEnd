package br.com.ControleDeAtividades.domain.pessoa_projeto_atividade

import br.com.ControleDeAtividades.domain.atividade_dependente.AtividadeDependente
import java.util.*

interface PessoaProjetoAtividadeRepository {
    fun inserir(pessoaProjetoAtividade: PessoaProjetoAtividade): Boolean
    fun buscarTodos(): List<PessoaProjetoAtividade>
    fun buscarAtividadesProjetoPorPessoa(cpf_pessoa: String): List<PessoaProjetoAtividade>?
    fun deletar(pessoaProjetoAtividade: PessoaProjetoAtividade)
    fun atualizar(pessoaProjetoAtividade: PessoaProjetoAtividade): Boolean
}