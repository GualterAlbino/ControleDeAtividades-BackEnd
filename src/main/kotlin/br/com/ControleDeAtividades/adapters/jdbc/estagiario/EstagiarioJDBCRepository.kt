package br.com.ControleDeAtividades.adapters.jdbc.estagiario

import br.com.ControleDeAtividades.adapters.jdbc.estagiario.EstagiarioSQLExpressions.sqlDeleteEstagiarioById
import br.com.ControleDeAtividades.adapters.jdbc.estagiario.EstagiarioSQLExpressions.sqlInsertEstagiario
import br.com.ControleDeAtividades.adapters.jdbc.estagiario.EstagiarioSQLExpressions.sqlSelectAllEstagiario
import br.com.ControleDeAtividades.adapters.jdbc.estagiario.EstagiarioSQLExpressions.sqlUpdateEstagiario
import br.com.ControleDeAtividades.domain.estagiario.Estagiario
import br.com.ControleDeAtividades.domain.estagiario.EstagiarioRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository

@Repository
class EstagiarioJDBCRepository (
        private val db : NamedParameterJdbcOperations
) : EstagiarioRepository {
    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun inserir(estagiario: Estagiario): Boolean {
        try {
            val params = parametros(estagiario)
            db.update(sqlInsertEstagiario(), params)
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao inserir o estagiario: ${ex.message}" }
            throw ex
        }
        return true
    }

    override fun buscarTodos(): List<Estagiario> {
        val estagiario = try {
            db.query(
                    sqlSelectAllEstagiario(),
                    rowMapper()
            )
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao consultar os estagiarios: ${ex.message}" }
            throw ex
        }
        return estagiario
    }

    override fun buscarPorId(estagiarioRa: Int): Estagiario? {
        val estagiario = try {
            val params = MapSqlParameterSource("ra", estagiarioRa)
            db.query(sqlDeleteEstagiarioById(), params, rowMapper()).firstOrNull()
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao consultar o estagiario: ${ex.message}" }
            throw ex
        }
        return estagiario
    }

    override fun deletar(estagiarioRa: Int): Boolean {
        try {
            val params = MapSqlParameterSource("ra", estagiarioRa)
            db.update(sqlDeleteEstagiarioById(), params)
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao deletar o estagiario: ${ex.message}" }
            throw ex
        }
        return true
    }

    override fun atualizar(estagiario: Estagiario): Boolean {
        try {
            val params = parametros(estagiario)
            db.update(sqlUpdateEstagiario(), params)
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao atualizar o estagiario: ${ex.message}" }
            throw ex
        }
        return true
    }

    private fun rowMapper () = RowMapper<Estagiario> { rs, _ ->
        Estagiario (
                ra = rs.getInt("ra"),
                cpf_pessoa = rs.getString("cpf_pessoa"),
                periodo = rs.getString("periodo"),
                curso = rs.getString("curso")
        )

    }

    private fun parametros(estagiario: Estagiario) : MapSqlParameterSource {
        val params = MapSqlParameterSource()
        params.addValue("ra", estagiario.ra)
        params.addValue("cpf_pessoa", estagiario.cpf_pessoa)
        params.addValue("periodo", estagiario.periodo)
        params.addValue("curso", estagiario.curso)
        return params
    }
}