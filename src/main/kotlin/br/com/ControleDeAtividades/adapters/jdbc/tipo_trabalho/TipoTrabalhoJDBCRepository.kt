package br.com.CarteiraDeInvestimentos.adapters.jdbc.transacao


import br.com.ControleDeAtividades.adapters.jdbc.tipo_trabalho.TipoTrabalhoSQLExpressions
import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalho
import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalhoRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TipoTrabalhoJDBCRepository(private val db: NamedParameterJdbcOperations ) : TipoTrabalhoRepository{

    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun buscarTodos(): List<TipoTrabalho> {
        val objetos = db.query(TipoTrabalhoSQLExpressions.sqlSelectAllTipoTrabalho(), rowMapper())
        return objetos
    }

    override fun buscarPorId(id: UUID): TipoTrabalho? {
        try {
            val params = MapSqlParameterSource("id", id)
            val objetoProcurado = db.query(TipoTrabalhoSQLExpressions.sqlSelectByIdTipoTrabalho(), params, rowMapper()).firstOrNull();

            return objetoProcurado;

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar : ${ex.message}" }
            throw ex
        }

    }



    override fun inserir(objeto: TipoTrabalho): Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("id", objeto.id)
            params.addValue("ticket", objeto.descricao)

            val linhasAfetadas = db.update(TipoTrabalhoSQLExpressions.sqlInsertTipoTrabalho(),params)

            return linhasAfetadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao inserir : ${ex.message}" }
            throw ex
        }
    }

    override fun atualizar(objeto: TipoTrabalho):Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("id", objeto.id)
            params.addValue("ticket", objeto.descricao)

            val linhasAfestadas = db.update(TipoTrabalhoSQLExpressions.sqlUpdateTipoTrabalho(), params)

            return linhasAfestadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao atualizar : ${ex.message}" }
            throw ex
        }
    }

    override fun excluir(id: UUID): Boolean {
        try {
            val params = MapSqlParameterSource("id", id)
            val linhasExcluidas = db.update(TipoTrabalhoSQLExpressions.sqlDeleteByIdTipoTrabalho(), params)

            return linhasExcluidas == 1

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao excluir: ${ex.message}" }
            throw ex
        }
    }


    private fun rowMapper()= org.springframework.jdbc.core.RowMapper<TipoTrabalho> { rs, _ ->
        val objetoID = UUID.fromString(rs.getString("id"))
        TipoTrabalho(
                id = objetoID,
                descricao = rs.getString("descricao")
        )
    }





}