package br.com.ControleDeAtividades.adapters.jdbc.projeto

import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoSQLExpressions.sqlDeleteById
import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoSQLExpressions.sqlInsertProjeto
import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoSQLExpressions.sqlSelectAll
import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoSQLExpressions.sqlSelectById
import br.com.ControleDeAtividades.adapters.jdbc.projeto.ProjetoSQLExpressions.sqlUpdateProjeto
import br.com.ControleDeAtividades.domain.projeto.Projeto
import br.com.ControleDeAtividades.domain.projeto.ProjetoRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.transaction.annotation.Transactional
import java.util.*
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class ProjetoJDBCRepository (
    private val db : NamedParameterJdbcOperations
) : ProjetoRepository {

    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun inserir(projeto: Projeto): Boolean {
        try {

            val params = parametros(projeto)
            val linhasAfetadas = db.update(
                sqlInsertProjeto(),
                params
            )

            return linhasAfetadas > 0
        } catch (ex: Exception) {
            LOGGER.error(ex) { "Erro ao inserir o projeto: ${ex.message}" }
            throw ex
        }
    }

    override fun buscarTodos(): List<Projeto> {
        val projetos = try {
            db.query(
                sqlSelectAll(),
                rowMapper()
            )
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao consultar os projetos: ${ex.message}" }
            throw ex
        }

        return projetos
    }

    override fun buscarPorId(projetoId: UUID): Projeto? {
        val projeto = try {
            val params = MapSqlParameterSource("id", projetoId.toString())
            db.query(sqlSelectById(), params, rowMapper()).firstOrNull()
        } catch (ex: Exception) {
            LOGGER.error { "Houve um erro ao consultar o projeto: ${ex.message}" }
            throw ex
        }
        return projeto
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun deletar(projetoId: UUID): Boolean {
        try {
            val params = MapSqlParameterSource("id", projetoId.toString())
            val linhasExcluidas = db.update(
                    sqlDeleteById(),
                    params
            )

            return linhasExcluidas == 0
        } catch (ex: Exception) {
            LOGGER.error(ex) { "Erro ao deletar o projeto: ${ex.message}" }
            throw ex
        }
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun atualizar(projeto: Projeto): Boolean {
        try {
            val params = parametros(projeto)
            val linhasAfetadas = db.update(
                    sqlUpdateProjeto(),
                    params
            )
            return linhasAfetadas > 0
        } catch (ex: Exception) {
            LOGGER.error(ex) { "Erro ao atualizar o projeto: ${ex.message}" }
            throw ex
        }
    }

    private fun rowMapper () = RowMapper<Projeto> { rs, _ ->
        val projetoId = UUID.fromString(rs.getString("id"))
        Projeto(
                id = projetoId,
                cpf_coordenador = rs.getString("cpf_coordenador"),
                nome = rs.getString("nome"),
                objetivo = rs.getString("objetivo"),
                recursos = rs.getString("recursos")
        )
    }

    private fun parametros (projeto: Projeto): MapSqlParameterSource {
        val params = MapSqlParameterSource()
        params.addValue("id", projeto.id.toString())
        params.addValue("cpf_coordenador", projeto.cpf_coordenador)
        params.addValue("nome", projeto.nome)
        params.addValue("objetivo", projeto.objetivo)
        params.addValue("recursos", projeto.recursos)
        return params
    }
}
