package br.com.ControleDeAtividades.domain.tipo_trabalho

import java.util.UUID

interface TipoTrabalhoRepository {
    fun buscarTodos():List<TipoTrabalho>
    fun buscarPorId(id: UUID):TipoTrabalho?
    fun inserir(objeto: TipoTrabalho): Boolean
    fun excluir(id: UUID):Boolean
    fun atualizar(objeto: TipoTrabalho):Boolean
}