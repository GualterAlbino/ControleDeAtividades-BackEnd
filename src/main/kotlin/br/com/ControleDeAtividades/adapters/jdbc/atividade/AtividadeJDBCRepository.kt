package br.com.ControleDeAtividades.adapters.jdbc.atividade

import br.com.ControleDeAtividades.adapters.jdbc.atividade.AtividadeSQLExpressions.sqlDeleteById
import br.com.ControleDeAtividades.adapters.jdbc.atividade.AtividadeSQLExpressions.sqlInsertAtividade
import br.com.ControleDeAtividades.adapters.jdbc.atividade.AtividadeSQLExpressions.sqlSelectAll
import br.com.ControleDeAtividades.adapters.jdbc.atividade.AtividadeSQLExpressions.sqlSelectById
import br.com.ControleDeAtividades.adapters.jdbc.atividade.AtividadeSQLExpressions.sqlUpdateAtividade
import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoSQLExpressions
import br.com.ControleDeAtividades.domain.atividade.Atividade
import br.com.ControleDeAtividades.domain.atividade.AtividadeRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AtividadeJDBCRepository(
        private val db: NamedParameterJdbcOperations
) : AtividadeRepository {
    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun inserir(atividade: Atividade): Boolean {
        try {
            val params = parametros(atividade)
            val linhasAfetadas = db.update(
                    sqlInsertAtividade(),
                    params
            )

            return linhasAfetadas > 0
        } catch (ex: Exception) {
            LOGGER.error(ex) { "Erro ao inserir a atividade: ${ex.message}" }
            throw ex
        }
    }

    override fun buscarTodos(): List<Atividade> {

        val atividades = try {
            db.query(
                    sqlSelectAll(),
                    rowMapper()
            )
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao consultar as atividades: ${ex.message}" }
            throw ex
        }
        return atividades
    }

    override fun buscarPorId(atividadeId: UUID): Atividade? {
        val ativiade = try {
            val params = MapSqlParameterSource("id", atividadeId.toString())
            db.query(sqlSelectById(), params, rowMapper()).firstOrNull()
        } catch (ex: Exception) {
            ex.printStackTrace()
            LOGGER.error { "Houve um erro ao consultar a atividade: ${ex.message}" }
            throw ex
        }
        return ativiade
    }

    override fun deletar(atividadeId: UUID): Boolean {
        try {
            val params = MapSqlParameterSource("id", atividadeId.toString())
            val linhasExcluidas = db.update(
                    sqlDeleteById(),
                    params
            )
            return linhasExcluidas == 0
        } catch (ex: Exception) {
            LOGGER.error(ex) { "Erro ao deletar a atividade: ${ex.message}" }
            throw ex
        }
    }

    override fun atualizar(atividade: Atividade): Boolean {
        try {
            val params = parametros(atividade)
            val linhasAfetadas = db.update(
                    sqlUpdateAtividade(),
                    params
            )
            return linhasAfetadas > 0
        } catch (ex: Exception) {
            LOGGER.error(ex) { "Erro ao atualizar a atividade: ${ex.message}" }
            throw ex
        }
    }

    private fun rowMapper() = RowMapper<Atividade> { rs, _ ->
        val atividadeId = UUID.fromString(rs.getString("id"))
        Atividade(
                id = atividadeId,
                id_tipo_trabalho = UUID.fromString(rs.getString("id_tipo_trabalho")),
                id_historico = UUID.fromString(rs.getString("id_historico")),
                descricao = rs.getString("descricao"),
                finalizada = rs.getBoolean("finalizada"),
                cpf_professor_responsavel = rs.getString("cpf_professor_responsavel")
        )
    }

    private fun parametros(atividade: Atividade): MapSqlParameterSource {
        val params = MapSqlParameterSource()
        params.addValue("id", atividade.id)
        params.addValue("id_tipo_trabalho", atividade.id_tipo_trabalho)
        params.addValue("id_historico", atividade.id_historico)
        params.addValue("descricao", atividade.descricao)
        params.addValue("finalizada", atividade.finalizada)
        params.addValue("cpf_professor_responsavel", atividade.cpf_professor_responsavel)
        return params
    }
}