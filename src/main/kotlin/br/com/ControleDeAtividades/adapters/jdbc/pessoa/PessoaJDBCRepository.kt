package br.com.ControleDeAtividades.adapters.jdbc.pessoa

import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import br.com.ControleDeAtividades.domain.pessoa.PessoaRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class PessoaJDBCRepository(private val db: NamedParameterJdbcOperations) : PessoaRepository{

    private companion object {
        val LOGGER = KotlinLogging.logger { }
    }

    override fun findAll(): List<Pessoa> {
        val pessoas = db.query(PessoaSQLExpressions.sqlSelectAllPessoa(), rowMapper())
        return pessoas
    }

    override fun findByCpf(cpf: String): Pessoa? {
        try {
            val params = MapSqlParameterSource("cpf", cpf)
            val usuarioProcurado = db.query(PessoaSQLExpressions.sqlSelectByIdPessoa(), params, rowMapper()).firstOrNull();

            return usuarioProcurado;

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar o usuario: ${ex.message}" }
            throw ex
        }

    }

    override fun inserir(pessoa: Pessoa): Boolean {
        try {

            val params = MapSqlParameterSource()
            params.addValue("cpf", pessoa.cpf)
            params.addValue("email", pessoa.email)
            params.addValue("nome", pessoa.nome)
            params.addValue("rg", pessoa.rg)
            params.addValue("academico", pessoa.academico)
            params.addValue("atividade_execucao", pessoa.atividadeExecucao)
            params.addValue("nome_mae", pessoa.nome_mae)
            params.addValue("nome_pai", pessoa.nome_pai)
            params.addValue("tel_residencial", pessoa.tel_residencial)
            params.addValue("tel_recado", pessoa.tel_recado)
            params.addValue("tel_celular", pessoa.tel_celular)


            val linhasAfetadas = db.update(PessoaSQLExpressions.sqlInsertPessoa(),params)

            return linhasAfetadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro o usuario: ${ex.message}" }
            throw ex
        }
    }

    override fun atualizar(pessoa: Pessoa):Boolean {
        try {
            val params = MapSqlParameterSource()
            params.addValue("cpf", pessoa.cpf)
            params.addValue("email", pessoa.email)
            params.addValue("nome", pessoa.nome)
            params.addValue("rg", pessoa.rg)
            params.addValue("academico", pessoa.academico)
            params.addValue("atividade_execucao", pessoa.atividadeExecucao)
            params.addValue("nome_mae", pessoa.nome_mae)
            params.addValue("nome_pai", pessoa.nome_pai)
            params.addValue("tel_residencial", pessoa.tel_residencial)
            params.addValue("tel_recado", pessoa.tel_recado)
            params.addValue("tel_celular", pessoa.tel_celular)

            val linhasAfestadas = db.update(PessoaSQLExpressions.sqlUpdatePessoa(), params)

            return linhasAfestadas > 0

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao atualizar a transação: ${ex.message}" }
            throw ex
        }
    }

    override fun excluir(cpf: String): Boolean {
        try {

            val params = MapSqlParameterSource("cpf", cpf)
            val linhasExcluidas = db.update(PessoaSQLExpressions.sqlDeletePessoaByCpf(), params)

            return linhasExcluidas == 1

        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao excluir a transação: ${ex.message}" }
            throw ex
        }
    }


    private fun rowMapper()= org.springframework.jdbc.core.RowMapper<Pessoa> { rs, _ ->
        val usuarioId = UUID.fromString(rs.getString("id"))
        Pessoa(
                cpf = rs.getString("cpf"),
                email = rs.getString("email"),
                rg = rs.getString("rg"),
                nome = rs.getString("nome"),
                academico = rs.getString("academico"),
                atividadeExecucao = rs.getBoolean("atividade_execucao"),
                nome_mae = rs.getString("nome_mae"),
                nome_pai = rs.getString("nome_pai"),
                tel_residencial = rs.getString("tel_residencial"),
                tel_recado = rs.getString("tel_recado"),
                tel_celular = rs.getString("tel_celular")



        )
    }



}