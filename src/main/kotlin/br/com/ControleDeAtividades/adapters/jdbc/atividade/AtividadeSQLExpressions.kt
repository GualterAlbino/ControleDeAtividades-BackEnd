package br.com.ControleDeAtividades.adapters.jdbc.atividade

object AtividadeSQLExpressions {
    fun sqlSelectAll() = """SELECT id, id_tipo_trabalho, id_historico, descricao, finalizada, cpf_professor_responsavel FROM Atividade""".trimIndent()

    fun sqlSelectById() = """SELECT id, id_tipo_trabalho, id_historico, cpf_professor_responsavel, descricao, finalizada FROM Atividade WHERE id = :id""".trimIndent()

    fun sqlInsertAtividade() = """INSERT INTO Atividade( id, id_tipo_trabalho, id_historico, descricao, finalizada, cpf_professor_responsavel) VALUES (:id, :id_tipo_trabalho, :id_historico, :descricao, :finalizada, :cpf_professor_responsavel )""".trimIndent()

    fun sqlUpdateAtividade() = """
    UPDATE Atividade
    SET id_tipo_trabalho = :id_tipo_trabalho,
        id_historico = :id_historico,
        descricao = :descricao, 
        finalizada = :finalizada, 
        cpf_professor_responsavel = :cpf_professor_responsavel                
    WHERE id = :id
    """.trimIndent()

    fun sqlDeleteById() = """
    DELETE FROM Atividade 
    WHERE id = :id
    """.trimIndent()
}