package br.com.ControleDeAtividades.application.tipo_trabalho

import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalho

import kotlinx.serialization.Serializable

@Serializable
data class TipoTrabalhoCreateComand(
        val descricao :String

)

fun TipoTrabalhoCreateComand.toTipoDeTrabalho() = TipoTrabalho(
       descricao = descricao


)