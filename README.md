<img src="./Estacio horizontal.png" align="left" height="64px" /><br><br>
# Curso: Desenvolvimento Full Stack
## Mundo 3 - Nível 3 - Missão Prática

## RPG0016  - BackEnd sem banco não tem

**Autor:** Carlos Altomare Catao

**Curso:** Desenvolvedor Full Stack (Estácio - Mundo 3)

**Matrícula:** 202403460912

**Polo:** Santa Luzia - Vitória/ES

---
## 🎯 Objetivo da Prática

Criação de aplicativo Java, com acesso ao banco de dados SQL Server através do middleware JDBC.
	Etapas:
1.	Implementar persistência com base no middleware JDBC.
2.	Utilizar o padrão DAO (Data Access Object) no manuseio de dados.
3.	Implementar o mapeamento objeto-relacional em sistemas Java.
4.	Criar sistemas cadastrais com persistência em banco relacional.
5.	No final do exercício, o aluno terá criado um aplicativo cadastral com uso do SQL Server na persistência de dados.

Esta prática esta dividida em dois procedimentos:
- Procedimento 1: Mapeamento Objeto-Relacional e DAO
- Procedimento 2: Alimentando a Base

## 🗺️ Visão Geral

O projeto é uma aplicação Java console que realiza operações CRUD (Criar, Ler, Atualizar, Deletar) para pessoas físicas e jurídicas. Os dados são armazenados e persistidos em Banco de Dados SQL Server e manipulados por meio de classes DAO (Data Access Object).

## 🛠️ Funcionalidades Implementadas

1.	Conexão com o banco: A comunicação com o banco de dados SQL Server foi estabelecida por intermédio do driver mssql-jdbc-12.10.0.jre11.jar.
2.	Criação de objetos de negócio: As classes de entidade foram estruturadas com herança e polimorfismo.
3.	Operações CRUD:
* Inclusão de pessoas físicas e jurídicas (tabelas Pessoa, Pessoa_Fisica, Pessoa_Juridica) 
* Alteração e exclusão dos dados persistidos
* Listagem geral das pessoas cadastradas
4.	Controle de sequência: O SequenceManager foi utilizado para gerenciar as sequências da chave primária no banco de dados SQL Server.

O sistema foi implementado com um menu interativo que permite as seguintes operações:

1. Incluir – Cadastro de novas pessoas físicas ou jurídicas.
2. Alterar – Edição de dados existentes.
3. Excluir – Remoção de registros com base no Código da Pessoa.
4. Exibir pelo ID – Consulta de dados específicos.
5. Exibir todos – Listagem completa de registros.
6. Sair – Finalização do sistema.

A opção entre Pessoa Física ou Jurídica é selecionada pelo usuário a cada operação, garantindo, assim, flexibilidade e controle.  A entrada dos dados ocorre via teclado, com feedback sobre as ações realizadas exibido no console.

## 🧩 Estrutura do Projeto

```
MUNDO_3_NIVEL_3-MISSAO_PRATICA
│
├── Procedimento 1
│   │
│   ├── CadasroBD
│   │
│   ├── Procedimento-1.pdf
│   │
│   └── RESULTADOS.pdf
│
├── Procedimento 2
│   │
│   ├── CadasroBD
│   │
│   ├── Procedimento-2.pdf
│   │
│   └── RESULTADOS.pdf
│
├── RELATORIO_MISSAO_PRATICA_MUNDO_3_NIVEL_3.pdf
│
└── README.md
```

## 📦 Estrutura de Pacotes

```text
cadastrobd
├── CadastroBD.java              # Classe principal com menu interativo
├── model
│   ├── Pessoa.java              # Classe base abstrata
│   ├── PessoaFisica.java       # Subclasse para pessoas físicas
│   ├── PessoaJuridica.java     # Subclasse para pessoas jurídicas
│   ├── PessoaFisicaDAO.java    # DAO para PessoaFisica
│   ├── PessoaJuridicaDAO.java  # DAO para PessoaJuridica
├── util
    ├── ValidaOpcao.java        # Valida entradas e confirmações
    ├── ValidaTipoPessoa.java   # Verifica e obtém tipo F/J
    ├── ValidaCodigoPessoa.java # Validação de código numérico
```

## ⚙️ Detalhamento das Funções

### `incluirPessoa(Scanner scanner)`

Permite incluir uma nova pessoa no cadastro.

* Solicita se é Pessoa Física (F) ou Jurídica (J).
* Solicita os dados necessários, incluindo CPF/CNPJ.
* Instancia a entidade e chama o DAO correspondente.

### `alterarPessoa(Scanner scanner)`

Edita os dados de uma pessoa existente a partir de seu código.

* Exibe os dados atuais.
* Permite alterar somente os campos informados.
* Valida CPF ou CNPJ se alterado.

### `excluirPessoa(Scanner scanner)`

Realiza a exclusão de uma pessoa por código.

* Exibe os dados antes de excluir.
* Solicita confirmação do usuário.

### `exibirPorCodPessoaId(Scanner scanner)`

Exibe uma pessoa pelo seu código e tipo (F ou J).

* Valida a entrada e busca via DAO correspondente.

### `exibirTodos(Scanner scanner)`

Lista todas as pessoas do tipo especificado (Física ou Jurídica).


## 📋 Requisitos do Projeto

-	JDK ( Java Development Kit );
-	IDE NetBeans;
-	Banco de dados SQL Server;
-	SQL Server Management Studio (SSMS);
-	Driver JDBC ( Java Database Connectivity ) para SQL Server;
-	O Banco de Dados gerado na Missão Prática do Nível 2 (loja);
-	Navegador para Internet, como o Chrome;
- 	Computador com acesso à Internet.


## 🧪 Testes
Foram explorados testes de inclusão, alteração, exclusão e listagem.  Como aprendizado importante há que se destacar o aspecto relativo às permissões necessárias para se efetuar as transações junto ao banco de dados.

-	O uso do conn.setAutoCommit(false) com commit() e rollback() permitiu controle transacional, evitando corrupção de dados em falhas intermediárias.
- A listagem no console (via exibir()) confirmou a integridade das operações exploradas nos testes.
- Os dados eram corretamente persistidos nas tabelas.
- As operações refletiam em tempo real no banco.
- A integridade preservada entre as tabelas Pessoa, Pessoa_Fisica e Pessoa_Juridica.
- A sequência utilizada (seq_pessoa) gerava códigos únicos.

## ⚠️ Desafios Enfrentados

Durante o desenvolvimento desta atividade prática observou-se diversos desafios técnicos, entre os quais pode-se destacar:

- A implementação correta da lógica de exclusão em um banco de dados relacional, respeitando as restrições de integridade referencial.
- A garantia de que os dados fossem manipulados de forma segura e validada, especialmente, nas operações de alteração e consulta por código de pessoa.
- O ajuste da estrutura das queries SQL para garantir que os filtros fossem aplicados corretamente.

Essas dificuldades exigiram uma análise criteriosa e cuidadosa da modelagem do banco de dados e reforçaram a importância do planejamento da arquitetura relacional, validações consistentes e uso adequado de transações. Superar esses obstáculos contribuiu significativamente para o aprendizado prático e o amadurecimento técnico no uso do JDBC, SQL Server e boas práticas de programação em Java.

## 🧠 Análise e Conclusão

O projeto atendeu satisfatoriamente aos objetivos propostos, proporcionando uma experiência completa de interação com banco de dados via Java e JDBC. A separação por camadas (modelo, DAO, utilitário) contribuiu para um código limpo, reutilizável e de fácil manutenção.

A implementação do modo texto tornou a aplicação mais amigável ao usuário, garantindo uma melhor usabilidade, e desta forma foi ideal para fins didáticos e como base para futuras evoluções.

Esse exercício proporcionou aprendizado prático valioso sobre acesso a banco de dados, estruturação de sistemas e tratamento de dados em aplicações Java.

O projeto demonstrou como aplicações Java podem interagir de forma robusta com bancos de dados relacionais, aplicando boas práticas de POO e JDBC.  A modularização em pacotes, o uso de DAO, o controle de transações e a organização do código tornam o sistema facilmente escalável e compreensível, o que facilita em muito a depuração do código e sua manutenabilidade.

Esta prática permitiu consolidar conhecimentos técnicos importantes, como:
- A conexão com SQL Server via JDBC
- Estruturação de aplicações com camadas separadas
- Tratamento de exceções e recursos (fechamento de ResultSet, Statement, Connection)
- Operações CRUD usando SQL nativo

## ❓ Questionamentos

**1. Qual a importância dos componentes de middleware, como o JDBC?**  
O JDBC é responsável por intermediar a comunicação (middleware) entre aplicações Java e bancos de dados relacionais, garantindo eficiência, segurança e padronização no acesso a dados.

**2. Qual a diferença no uso de Statement ou PreparedStatement para a manipulação de dados?**  
Statement executa comandos SQL simples, enquanto PreparedStatement permite comandos parametrizados, oferecendo maior segurança contra injeções de SQL, melhor desempenho em consultas repetidas.

**3. Como o padrão DAO melhora a manutenibilidade do software?**  
O padrão DAO isola a lógica de acesso a dados do restante da aplicação, facilitando futuras manutenções, a possível troca do SGBD (Sistema Gerenciador do Banco de Dados) e a organização do código.

**4. Como a herança é refletida no banco de dados, quando lidamos com um modelo estritamente relacional?**
No modelo relacional, a herança é geralmente implementada usando tabelas separadas para cada classe, utilizando chaves estrangeiras para representar a relação entre as tabelas.

**5. Quais as diferenças entre a persistência em arquivo e a persistência em banco de dados?**  
•  Arquivos são mais simples e usados em projetos pequenos. Os dados são gravados em formatos como texto ou binário.
•  Bancos de dados são mais organizados, permitem consultas com SQL, suportam muitos usuários ao mesmo tempo e garantem integridade dos dados.
•  Arquivos exigem mais código para buscar e organizar os dados, enquanto bancos de dados já oferecem ferramentas para isso.

**6. Como o uso de operador lambda simplificou a impressão dos valores contidos nas entidades, nas versões mais recentes do Java?**  
Antes do Java 8, a impressão de valores exigia loops explícitos como:
for (Pessoa p : lista) {
    System.out.println(p.getNome());
}
Com expressões lambda, isso pode ser simplificado:
lista.forEach(p -> System.out.println(p.getNome()));
•  Código mais conciso, legível e funcional.
•  Facilita o uso de APIs como Streams para filtragem, ordenação e transformação de dados.

**7. Por que métodos acionados diretamente pelo método main, sem o uso de um objeto, precisam ser marcados como static?**  
O método main é o ponto de entrada da aplicação Java, e ele próprio é static. Isso significa que:
•	Ele é chamado sem instanciar a classe.
•	Portanto, qualquer método invocado diretamente por main também precisa ser static, pois métodos não estáticos só podem ser acessados através de um objeto (instância da classe).

---

## 📁 Documentação

O relatório completo da prática pode ser acessado no arquivo:

- [📄 RELATORIO_MISSAO_PRATICA_MUNDO_3_NIVEL_3.pdf](./RELATORIO_MISSAO_PRATICA_MUNDO_3_NIVEL_3.pdf)


---

## 🔗 Repositório Git

> https://github.com/CarlosCatao/Mundo_3_Nivel_3_Missao_Pratica

---


