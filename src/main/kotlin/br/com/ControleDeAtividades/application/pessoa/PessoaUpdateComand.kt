package br.com.ControleDeAtividades.application.pessoa
import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class PessoaUpdateComand(
        val cpf :String,
        val email: String,
        val rg: String,
        val nome: String,
        val academico: String,
        val atividade_execucao: Boolean,
        val nome_mae: String,
        val nome_pai: String,
        val tel_residencial: String,
        val tel_recado: String,
        val tel_celular: String
)

fun PessoaUpdateComand.toPessoa() = Pessoa (
        cpf = cpf,
        email = email,
        rg = rg,
        nome = nome,
        academico = academico,
        atividadeExecucao = atividade_execucao,
        nome_mae = nome_mae,
        nome_pai = nome_pai,
        tel_residencial = tel_residencial,
        tel_recado = tel_recado,
        tel_celular = tel_celular
)