package br.com.CarteiraDeInvestimentos.application.usuario

import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalho
import kotlinx.serialization.Serializable
import java.util.*


@Serializable
data class TipoTrabalhoUpdateComand(
        val descricao :String
)

fun TipoTrabalhoUpdateComand.toTipoTrabalho(tipoTrabalhoId: UUID) = TipoTrabalho(
        id = tipoTrabalhoId,
        descricao = descricao

)