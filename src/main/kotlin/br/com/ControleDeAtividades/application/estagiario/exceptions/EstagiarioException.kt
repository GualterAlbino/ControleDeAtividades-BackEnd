package br.com.ControleDeAtividades.application.estagiario.exceptions

sealed class EstagiarioException (message: String): Exception(message) {
    abstract val estagiarioRa : Int?
}

data class EstagiarioNotFoundException (
        override val estagiarioRa: Int?
): EstagiarioException("Estagiario ${estagiarioRa} não encotrado.")