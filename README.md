

# Crud--SpringBoot
CRUD feito com Spring Boot utilizando da linguagem Kotlin


@lateinit: Forma de tardiar a definição/instância de um valor para a variável

@Autowired: forma de fazer com que o Spring realize essa definição de valor
de forma automática (Injeção de dependência).


### ROTAS REST:

@GetMapping: realizar ação para retornar algo para o usuário,
quando ocorrer a chamada da API.
 
 
@PostMapping: realizar ação para enviar algo (nesse caso um contato)
para o Banco de dados quando ocorrer a chamada da Api.

@Valid: forma de validar e mostrar o erro que ocorreu em determinado
campo da linha que vc está acrescentado Tabela,
seja no Console ou Postman por exemplo.
 
@RequestBody: pegar os dados que serão enviados do front para armazenar
no Banco de dados. Assim já criando uma instância da entidade ("Contact" nesse caso)
para serem enviados. É uma forma de pegar o corpo JSON
 
@PutMapping: realizar ação para atualizar algo (nesse caso um contato)
para o Banco de dados quando ocorrer a chamada da Api.
Lembre-se de setar o Id e um novo objeto instanciado do "Contact" para substituir
os valores do contato antigo com ".apply"

@DeleteMapping: realizar ação de deletar determinada linha da tabela, pegando esse contato
através do seu Id.

 * @orElseThrow: para lançar uma exceção caso não ache um campo
   da determinada linha da tabela (EntityNotFoundException).
