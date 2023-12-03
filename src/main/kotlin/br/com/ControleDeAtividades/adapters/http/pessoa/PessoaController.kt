import br.com.ControleDeAtividades.adapters.http.pessoa.PessoaHandler
import br.com.ControleDeAtividades.application.pessoa.PessoaCreateComand
import br.com.ControleDeAtividades.application.pessoa.PessoaUpdateComand
import br.com.ControleDeAtividades.domain.pessoa.Pessoa
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PessoaController(
        private val transacaoHandler: PessoaHandler
) {
    @GetMapping("/pessoas")
    fun findAll(): ResponseEntity<List<Pessoa>> {
        return transacaoHandler.findAll();
    }

    @GetMapping("/pessoas/{cpf}") //:$UUID_REGEX
    fun findById(@PathVariable cpf: String): ResponseEntity<Pessoa> {
        return transacaoHandler.findByCpf(cpf)
    }

    @PostMapping("/pessoas")
    fun inserir(@RequestBody pessoa: PessoaCreateComand): ResponseEntity<Pessoa> {

        return transacaoHandler.inserir(pessoa)
    }


    @DeleteMapping("/pessoas/{cpf}")
    fun excluir(@PathVariable cpf: String): ResponseEntity<String> {
        return transacaoHandler.excluir(cpf)
    }

    @PutMapping("/pessoas/{cpf}")
    fun atualizar(@RequestBody pessoa: PessoaUpdateComand, @PathVariable cpf: String): ResponseEntity<Pessoa> {
        return transacaoHandler.atualizar(pessoa, cpf)
    }






}