package br.com.ControleDeAtividades.adapters.jdbc.estagiario

object EstagiarioSQLExpressions {
    fun sqlSelectAllEstagiario() = """
    SELECT ra, 
           cpf_pessoa,
           periodo,
           curso
    FROM Estagiario
""".trimIndent()

    fun sqlSelectEstagiarioById() = """
    SELECT ra, 
           cpf_pessoa,
           periodo,
           curso
    FROM Estagiario 
    WHERE ra = :ra
""".trimIndent()

    fun sqlInsertEstagiario() = """
    INSERT INTO Estagiario(
        ra,
        cpf_pessoa,
        periodo,
        curso
    ) VALUES (
        :ra,
        :cpf_pessoa,
        :periodo,
        :curso
    )
""".trimIndent()

    fun sqlUpdateEstagiario() = """
    UPDATE Estagiario
    SET cpf_pessoa = :cpf_pessoa,
        periodo = :periodo,
        curso = :curso
    WHERE ra = :ra
""".trimIndent()

    fun sqlDeleteEstagiarioById() = """
    DELETE FROM Estagiario 
    WHERE ra = :ra
""".trimIndent()
}