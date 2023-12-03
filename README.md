<div align="center">
  
 ## Carteira de Investimentos
  
</div>

## 📁 Informações do projeto:

- Trata-se de um sistema para controle de atividades desempenhadas em Laboratório Acadêmico para o desenvolvimento de projetos. Deverão ser armazenados os projetos para que o coordenador possa acompanhá-los. Para isso, ele precisa armazenar dados de todos os projetos, relacionando as pessoas atuantes e a quantidade de horas que cada pessoa trabalhou em cada projeto.

Futuramente, as horas de entrada e saída serão computadas via impressão digital, entretanto, no momento, essa entrada de horários será feita pelo próprio usuário, no momento em que este inicia um determinado trabalho ou tarefa do projeto ao qual esteja alocado.

O responsável de cada projeto fará um cadastro de atividades e a partir deste cadastro inicial, os usuários alocados para trabalhar no projeto informarão a hora de início e a atividade que passarão a realizar. Ao final da tarefa, o usuário deverá informar a hora de término e qualquer outra observação que julgar necessária, relacionando com o respectivo projeto, em campo descritivo. Caso a atividade não esteja concluída ao final do turno, o usuário deve informar a hora de parada sem informar o final da atividade.

Deve existir um cadastro para o tipo de trabalho realizado, seja ele de manutenção, de implementação, de alteração ou criação, de modelagem, ou outro tipo qualquer pertinente ao projeto. Cada usuário pode estar associado a mais de um projeto. Sendo assim, um determinado usuário pode realizar diferentes atividades em projetos distintos em um mesmo dia, sendo necessária a divisão do seu tempo para cada atividade. Nestes casos, é importante que o usuário seja capaz de relacionar cada atividade ao seu projeto de origem além de informar início e fim de cada atividade. Vale lembrar que as atividades devem ser sempre bem definidas, e isto é papel do usuário responsável.

O sistema deverá permitir o cadastro de usuários, que são as pessoas que trabalham nos projetos e que cadastrarão suas atividades, com as respectivas horas de trabalho. Por conta disso, todo usuário cadastrado tem um perfil, seja ele administrador, coordenador de projeto ou recurso humano de projeto. A visão do usuário varia conforme seu perfil. Caso seja administrador, poderá ter acesso a todas as atividades de todos os usuários ativos no sistema, além de poder cadastrar usuários, projetos e atividades e visualizar todos os relatórios disponíveis no sistema. A visão do coordenador permite cadastrar projetos e atividades, e para os projetos nos quais esteja vinculado, é possível também visualizar informações a respeito dos recursos humanos, horas trabalhadas pelos recursos humanos em determinado projeto por período, horas por recurso humano, horas por projeto, dias trabalhados, entre outros.

As pessoas terão períodos alternados de vinculação (atividade) e não vinculação (férias, sem atividades, término de um estágio etc). No entanto, o seu cadastro não poderá ser perdido bem como as suas horas trabalhadas nos projetos deverão ser mantidas. Estes são dados importantes para a emissão de relatórios futuros referentes ao controle de horas de atividades desempenhadas nas dependências do laboratório.

Os usuários do sistema deverão estar separados em categorias referentes a sua vinculação com o Laboratório, a saber: Professor responsável (administrador), Professor colaborador (coordenador - orientador), estagiário do laboratório (colaborador - trabalha nos projetos e realiza manutenções nos laboratórios), estagiário supervisionado (colaborador - trabalha nos projetos), estagiário voluntário (colaborador - trabalha nos projetos).

Os dados pessoais do usuário, quando recurso, incluem nome, RG, CPF, telefones de contato (residencial, celular, recado), e-mail, nome do pai e da mãe, se é acadêmico ou não. Caso seja estagiário registra-se também seu RA, período e curso.

Para entrar no sistema, seja para cadastro de atividade ou acompanhamento, o usuário deverá seguir os seguintes passos: (i) realizar login, digitando login e senha; (ii) submeter; (iii) aguardar que o sistema verifique a validação do login e senha; (iv) caso login seja validado, o sistema carregará conforme perfil de usuário; (v) caso contrário, o sistema comunica ao usuário sobre o erro ao digitar login ou senha.

Para o cadastro de colaboradores, o usuário deve ser administrador. Para o cadastro de projetos o usuário deve ser administrador ou coordenador. O cadastro de projetos deve conter o nome do projeto, o seu objetivo, uma lista com os recursos de laboratório necessários (pode ser um campo de texto), uma lista com os colaboradores associados ao mesmo, uma lista com as atividades a serem desempenhadas no projeto.

Para o cadastro de atividades, o usuário deve estar vinculado ao projeto ou ser administrador ou coordenador.

As atividades dos projetos devem possuir a possibilidade de se indicar uma dependência, ou seja, não poderá ser iniciada antes de uma outra atividade ter sido finalizada, para que não se possa eliminar etapas no andamento dos projetos.
  
<hr>

## ✔️ Requisitos:
- Possuir o Docker Desktop instalado e devidamente configurado
- Possuir alguma Application Programming Interfaces, preferencialmente o POSTMAN devido as collections que acompanham os arquivos do projeto
- Recomandado o uso da IDE IntelliJ IDEA

<hr>

## ▶️ Utilização do projeto:

- Para utilização do projeto deve-se seguir os seguintes passos:

1. Após clonar o repositorio e abrir na IDE execute os comandos:

2.  `./gradlew build` para gerar os artefatos do projeto (.jar)
*Obs:* Caso ele apresente erro, pode prosseguir.

3. `docker build -t controle-image .` para buildar a imagem docker 

4. `docker-compose up -d ` para inicializar e subir os containers

5. Feito isso, será necessario que acesse o pgAdmin (SBD escolhido) no proprio navegador pelo link: `http://localhost:8081/browser/`

6. Ao acessar, deverá informar as credenciais de acesso ao painel administrativo:

7. email: `gualter@email.com` senha: `gualter` 
 *Obs* : Não utilizei variaveis de ambiente para facilitar o processo e correção do projeto.

    ![Imagem1](./documents/instrucoes/image1.png)

8. Ao acessar, deve clicar em ADICIONAR NOVO SERVIDOR. A seguir os passos:

    ![Imagem2](./documents/instrucoes/image2.png)

9. Aba Geral - Nome: `carteira`

    ![Imagem3](./documents/instrucoes/image3.png)

10. Aba Conexão - Host: `db`, Port:`5432`, Username: `carteira`, Password: `carteira`

    ![Imagem4](./documents/instrucoes/image4.png)

11. Ao clicar em salvar, se todos os dados estiverem corretos você conseguirá conectar com sucesso.

12. Feito isso,a proxima etapa é a de criação da tabela. O script SQL estará disponivel ao fim dessa página e dentro da pasta *documents* do proprio projeto.

13. No menu lateral esquerdo abra na ordem `carteira -> databases -> carteira-database`

14. Clique com botão direito do mouse sobre ele e selecione a opção `SCRIPT CREATE`

    ![Imagem5](./documents/instrucoes/image5.png)

15. Na janela que se abre apague TODO o conteudo e colo o script de criação do banco citado anteriormente. 
*Obs:* Será necessario executar bloco de comando a bloco de comando.

16. Feito isso, execute a aplicação (API) pela propria IDE, NÃO utilize a do Docker Desktop
*Motivo:* Devido a alguma incompatibilidade com a versão JAVA ela não está rodando dentro do container, mas fora funciona normalmente.

Após realizar esses passos,a API estará em execução e será possivel realizar as requisições.

<hr>

## ⚙️ Tecnologias utilizadas

- `Kotlin`
- `Spring`
- `Postgres`
- `Docker`

<hr>

## ⚙️ Modelo Entidade Relacionamento(DER):

<div align="center">
  
![ModeloDoBanco](./documents/der/MySQLModel%20-%20ProjetoPatico.png)

</div>
<hr>
<br>

## 💾 Script de criação das tabelas:

<div align="center">
  
![SCRIPT SQL](./documents/script/MySQLModel%20-%20ProjetoPatico.txt)


</div>

<hr>
<br>

## 🧭 Contrato de rotas da API:

<div align="center">
  
![Arquivo contendo as rotas (Contrato)](./documents/der/MySQLModel%20-%20ProjetoPatico.mwb)

</div>






