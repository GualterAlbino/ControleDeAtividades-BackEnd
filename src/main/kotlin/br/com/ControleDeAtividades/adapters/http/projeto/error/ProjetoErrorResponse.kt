package br.com.ControleDeAtividades.adapters.http.projeto.error

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ErrorResponse(
        @Serializable(with = UUIDSerializer::class) val id: UUID? = null,
        val message: String,
)