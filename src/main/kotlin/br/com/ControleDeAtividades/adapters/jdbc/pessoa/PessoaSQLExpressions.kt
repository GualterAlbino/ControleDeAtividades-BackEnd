package br.com.ControleDeAtividades.adapters.jdbc.pessoa

object PessoaSQLExpressions {
    fun sqlSelectAllPessoa() = "SELECT * FROM pessoa".trimIndent()


    fun sqlSelectByIdPessoa() = "SELECT * FROM pessoa WHERE id = :id".trimIndent()


    fun sqlInsertPessoa() = """
      INSERT INTO pessoa (cpf, email, rg, nome, academico, atividade_execucao, nome_mae, nome_pai, tel_residencial, tel_recado, tel_celular)
      VALUES (:cpf, :email, :rg, :nome, :academico, :atividade_execucao, :nome_mae, :nome_pai, :tel_residencial, :tel_recado, :tel_celular);

    """.trimIndent()

    fun sqlDeletePessoaByCpf() = """
        DELETE FROM pessoa WHERE cpf = :cpf
    """.trimIndent()


    fun sqlUpdatePessoa() = """UPDATE usuario
        SET
        cpf = :cpf,
        email = :email,
        rg = :rg,
        nome = :nome,
        academico = :academico,
        atividade_execucao = :atividade_execucao,
        nome_mae = :nome_mae,
        nome_pai = :nome_pai,
        tel_residencial = :tel_residencial,
        tel_recado = :tel_recado,
        tel_celular = :tel_celular     
    """.trimIndent()
}