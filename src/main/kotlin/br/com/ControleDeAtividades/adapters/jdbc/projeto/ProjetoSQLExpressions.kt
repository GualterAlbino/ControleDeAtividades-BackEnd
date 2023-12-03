package br.com.ControleDeAtividades.adapters.jdbc.projeto

object ProjetoSQLExpressions {
    fun sqlSelectAll() = """
    SELECT id, 
           cpf_coordenador,
           nome,
           objetivo,
           recursos
    FROM projeto
    """.trimIndent()

    fun sqlSelectById() = """SELECT id, cpf_coordenador, nome, objetivo, recursos FROM projeto WHERE id = :id""".trimIndent()

    fun sqlInsertProjeto() = """INSERT INTO projeto( id, cpf_coordenador, nome, objetivo, recursos) VALUES (:id , :cpf_coordenador, :nome, :objetivo, :recursos)""".trimIndent()

    fun sqlUpdateProjeto() = """UPDATE projeto SET cpf_coordenador = :cpf_coordenador, nome = :nome,  objetivo = :objetivo,  recursos = :recursos WHERE id = :id""".trimIndent()

    fun sqlDeleteById() = """DELETE FROM projeto WHERE id = :id""".trimIndent()
}