package br.com.ControleDeAtividades.domain.tipo_trabalho
import java.util.UUID

class TipoTrabalho (
        
        val id: UUID = UUID.randomUUID(),
        val descricao: String
)


