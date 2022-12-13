package com.example.demo.controllers

import com.example.demo.entities.ContactEntity
import com.example.demo.services.ContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.Valid


/**
 * @lateinit: Forma de tardiar a definição/instância de um valor para a variável
 *
 * @Autowired: forma de fazer com que o Spring realize essa definição de valor
 * de forma automática (Injeção de dependência).
 *
 * @1.°.: forma de injeção de dependência = Boa solução, mas qualquer membro vai poder ter acesso,
 * terá que anotar a dependência @Autowired várias vezes e a propriedade "var"
 * vai poder mudar de valor a qualquer momento
 *
 * @2.°.: pelo construtor primário (junto a Classe), funcionando para toda a aplicação
 * e deixando o atributo privado. Se tiver no construtor primário, não precisa usar o @Autowired
 *
 * ROTAS REST:
 *
 * @GetMapping: realizar ação para retornar algo para o usuário,
 * quando ocorrer a chamada da API.
 *
 * * @index(): função para listar todos os contatos. Do tipo "List".
 * * @show(): função para listar apenas um contato pelo Id.
 *
 * @PostMapping: realizar ação para enviar algo (nesse caso um contato)
 * para o Banco de dados quando ocorrer a chamada da Api.
 *
 * @Valid: forma de validar e mostrar o erro que ocorreu em determinado
 * campo da linha que vc está acrescentado Tabela,
 * seja no Console ou Postman por exemplo.
 *
 * @RequestBody: pegar os dados que serão enviados do front para armazenar
 * no Banco de dados. Assim já criando uma instância da entidade ("Contact" nesse caso)
 * para serem enviados. É uma forma de pegar o corpo JSON
 *
 * @PutMapping: realizar ação para atualizar algo (nesse caso um contato)
 * para o Banco de dados quando ocorrer a chamada da Api.
 * Lembre-se de setar o Id e um novo objeto instanciado do "Contact" para substituir
 * os valores do contato antigo com ".apply"
 *
 * @DeleteMapping: realizar ação de deletar determinada linha da tabela, pegando esse contato
 * através do seu Id.
 *
 * @orElseThrow: para lançar uma exceção caso não ache um campo
 * da determinada linha da tabela (EntityNotFoundException).
 *
 * Obs.: Lembre-se que cada instância de uma entidade representa uma linha da tabela.
 * */
@RestController
@RequestMapping("/contacts")
class ContactController /*2º*/ constructor(private val contactService: ContactService) {

//    1°
//    @Autowired
//    lateinit var repository: ContactRepository

    @GetMapping
    fun get(): ResponseEntity<List<ContactEntity>> {
        val allContacts = contactService.index()
        return ResponseEntity.ok(allContacts)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): ResponseEntity<ContactEntity> {
        val contact = contactService.show(id)
        return ResponseEntity.ok(contact)
    }

    @PostMapping
    fun post(@Valid @RequestBody contact: ContactEntity): ResponseEntity<ContactEntity> {
        val createContact = contactService.create(contact)
        return ResponseEntity.ok(createContact)
    }

    @PutMapping("/{id}")
    fun put(@Valid @PathVariable("id") id: Long, @RequestBody newContact: ContactEntity): ResponseEntity<ContactEntity> {
        val updateContact = contactService.update(id, newContact)
        return ResponseEntity.ok(updateContact)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        val removeContact = contactService.remove(id)
        return ResponseEntity.ok(removeContact)
    }

}