package br.com.CarteiraDeInvestimentos.application.usuario


import br.com.ControleDeAtividades.application.tipo_trabalho.TipoTrabalhoCreateComand
import br.com.ControleDeAtividades.application.tipo_trabalho.exceptions.TipoTrabalhoException
import br.com.ControleDeAtividades.application.tipo_trabalho.exceptions.TipoTrabalhoNaoEncontradoException
import br.com.ControleDeAtividades.application.tipo_trabalho.toTipoDeTrabalho
import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalho
import br.com.ControleDeAtividades.domain.tipo_trabalho.TipoTrabalhoRepository
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class TipoTrabalhoService(
        private val tipoTrabalhoRepository: TipoTrabalhoRepository,
) {
    fun buscarTodos(): List<TipoTrabalho>{
        return tipoTrabalhoRepository.buscarTodos()
    }

    fun buscarPorId(id: UUID):TipoTrabalho?{
        return tipoTrabalhoRepository.buscarPorId(id) ?: throw TipoTrabalhoNaoEncontradoException(id)
    }

    fun inserir(objeto: TipoTrabalhoCreateComand):TipoTrabalho?{

        val objetoDomain = objeto.toTipoDeTrabalho()

        tipoTrabalhoRepository.inserir(objetoDomain)

        if (objetoDomain != null) {
            return buscarPorId(objetoDomain.id)
        }
        return null


    }

    fun atualizar(objeto: TipoTrabalhoUpdateComand, id: UUID):TipoTrabalho?{
        tipoTrabalhoRepository.buscarPorId(id)?: throw  TipoTrabalhoNaoEncontradoException(id)

        tipoTrabalhoRepository.atualizar(objeto.toTipoTrabalho(id))

        return buscarPorId(id = id)

    }

    fun excluir(id: UUID){
        tipoTrabalhoRepository.buscarPorId(id)?: throw  TipoTrabalhoNaoEncontradoException(id)
        tipoTrabalhoRepository.excluir(id)
    }

}