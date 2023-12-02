package br.com.ControleDeAtividades.adapters.jdbc.tipo_trabalho

object TipoTrabalhoSQLExpressions {

    fun sqlSelectAllTipoTrabalho() = "SELECT * FROM tipo_de_trabalho".trimIndent()

    fun sqlSelectByIdTipoTrabalho() = "SELECT * FROM tipo_de_trabalho WHERE id = :id".trimIndent()

    fun sqlDeleteByIdTipoTrabalho() = """
        DELETE FROM tipo_de_trabalho WHERE id = :id
    """.trimIndent()

    fun sqlInsertTipoTrabalho() = """
       INSERT INTO tipo_de_trabalho(
           id,
           descricao)
        values (
           :id,
           :descricao
        )
    """.trimIndent()
    fun sqlUpdateTipoTrabalho() = """UPDATE tipo_de_trabalho
        SET
        descricao = :descricao""".trimIndent()
}