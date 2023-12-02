package br.com.CarteiraDeInvestimentos.adapters.http.transacao


import br.com.CarteiraDeInvestimentos.application.usuario.TipoTrabalhoService
import br.com.CarteiraDeInvestimentos.application.usuario.TipoTrabalhoUpdateComand
import br.com.ControleDeAtividades.application.tipo_trabalho.TipoTrabalhoCreateComand
import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalho
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class TipoTrabalhoHandler(
        private val tipoTrabalhoService: TipoTrabalhoService
) {
    fun buscarTodos(): ResponseEntity<List<TipoTrabalho>>{
        val objetos = tipoTrabalhoService.buscarTodos()
        return ResponseEntity.ok(objetos)
    }

    fun buscarPorId(id: String): ResponseEntity<TipoTrabalho>{

        val objetoProcurado = tipoTrabalhoService.buscarPorId(UUID.fromString(id))

        return ResponseEntity.ok(objetoProcurado)
    }

    fun inserir(transacaoCreateComand: TipoTrabalhoCreateComand): ResponseEntity<TipoTrabalho>{
        val transacao = tipoTrabalhoService.inserir(transacaoCreateComand)
        return ResponseEntity.status(HttpStatus.CREATED).body(transacao)
    }

    fun excluir(id : String):ResponseEntity<String>{
        tipoTrabalhoService.excluir(id = UUID.fromString(id))
        return ResponseEntity.noContent().build()
    }

    fun atualizar(objeto: TipoTrabalhoUpdateComand, id: String):ResponseEntity<TipoTrabalho>{
        val transacao = tipoTrabalhoService.atualizar(objeto, UUID.fromString(id))
        return ResponseEntity.ok(transacao)
    }
}