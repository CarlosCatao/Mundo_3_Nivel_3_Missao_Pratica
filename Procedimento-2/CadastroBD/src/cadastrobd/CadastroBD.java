/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd;

import java.util.List;
import java.util.Scanner;

import cadastrobd.model.*;
import cadastrobd.util.*;

public class CadastroBD {
    public static void main(String[] args) {
         System.out.println(">> Iniciando o programa...\n");
        int opcao = -1;

        Scanner scanner = new Scanner(System.in);
        
        do {
            try {
                System.out.println("======= MENU PRINCIPAL =======\n");
                System.out.println(" 1 - Incluir Pessoa");
                System.out.println(" 2 - Alterar Pessoa");
                System.out.println(" 3 - Excluir Pessoa");
                System.out.println(" 4 - Exibir Pessoa por Codigo");
                System.out.println(" 5 - Exibir Todas as Pessoas");
                System.out.println(" 0 - Sair\n");
                System.out.print("Escolha uma opcao: \n");
                System.out.println("==============================\n");               

                String entrada = scanner.nextLine();

                if (ValidaOpcao.validaOpcao(entrada, 0, 5)) {
                    opcao = ValidaOpcao.converterParaInteiro(entrada);
                } else {
                    continue;
                }

                switch (opcao) {
                    case 1 -> incluirPessoa(scanner);
                    case 2 -> alterarPessoa(scanner);
                    case 3 -> excluirPessoa(scanner);
                    case 4 -> exibirPorCodPessoa(scanner);
                    case 5 -> exibirTodos(scanner);
                    case 0 -> System.out.println(">> Encerrando o programa...\n");
                    default -> System.out.println(">>> ERRO ==> Opcao invalida! Tente novamente.\n");
                }

            } catch (Exception e) {
                System.out.println(">>> ERRO ==> Erro inesperado durante a execucao: " + e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
                
    }

    // Incluir Pessoas
    
    private static void incluirPessoa(Scanner scanner) {
        
        String tipopessoa = "";

        do {
            System.out.print("F - Pessoa Fisica | J - Pessoa Juridica): ");
            tipopessoa = scanner.nextLine();
        } while (!ValidaTipoPessoa.tipoValido(tipopessoa));

        tipopessoa = ValidaTipoPessoa.obterTipo(tipopessoa);
        
        //  Recebe Pessoa
        
        //  Recebe Nome
        String nome;

        while (true) {
            System.out.print("Nome: ");
             nome = scanner.nextLine();

            if (ValidaOpcao.stringValida(nome)) {
                break;
            } else {}
        }
        
        //  Recebe Endereco
        String endereco;

        while (true) {
            System.out.print("Endereco: ");
             endereco = scanner.nextLine();

            if (ValidaOpcao.stringValida(endereco)) {
                break;
            } else {}
        }

        //  Recebe Telefone
        String telefone;

        while (true) {
            System.out.print("Telefone: ");
             telefone = scanner.nextLine();

            if (ValidaOpcao.stringValida(telefone)) {
                break;
            } else {}
        }

        //  Recebe Email
        String email;

        while (true) {
            System.out.print("Email: ");
             email = scanner.nextLine();

            if (ValidaOpcao.stringValida(email)) {
                break;
            } else {}
        }

        //  Recebe Cidade
        String cidade;

        while (true) {
            System.out.print("Cidade: ");
             cidade = scanner.nextLine();

            if (ValidaOpcao.stringValida(cidade)) {
                break;
            } else {}
        }

        //  Recebe Estado        
        String estado;

        while (true) {
            System.out.print("Estado: ");
             estado = scanner.nextLine();

            if (ValidaOpcao.stringValida(estado)) {
                break;
            } else {}
        }

        //  Se for Pessoa Fisica
        if (tipopessoa.equals("F")) {
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            //  Recebe CPF
            String cpf;

            while (true) {
                System.out.print("CPF: ");
                cpf = scanner.nextLine();

                if (ValidaOpcao.stringValida(cpf)) {
                    break;
                } else {}
            }
                        
            PessoaFisica pf = new PessoaFisica(0, nome, endereco, telefone, email, cidade, estado, cpf);
            pfDao.incluir(pf);
            System.out.println(">>> CONFIRMACAO ==> Pessoa Fisica incluida com sucesso!\n");
            
        } else {
            //  Se for Pessoa Juridica
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            // Recebe CNPJ
            String cnpj;

            while (true) {
                System.out.print("CNPJ: ");
                cnpj = scanner.nextLine();

                if (ValidaOpcao.stringValida(cnpj)) {
                    break;
                } else {}
            }
       
            PessoaJuridica pj = new PessoaJuridica(0, nome, endereco, telefone, email, cidade, estado, cnpj);
            pjDao.incluir(pj);
            System.out.println(">>> CONFIRMACAO ==> Pessoa Juridica incluida com sucesso!\n");
        }
    }

    // Alterar Pessoas
    
    private static void alterarPessoa(Scanner scanner) {
        
        String tipopessoa;

        do {
            System.out.print("F - Pessoa Fisica | J - Pessoa Juridica): ");
            tipopessoa = scanner.nextLine();
        } while (!ValidaTipoPessoa.tipoValido(tipopessoa));

        tipopessoa = ValidaTipoPessoa.obterTipo(tipopessoa);

        // Validacao do codigo da pessoa
        
        int codpessoa;
        String entrada;
        
        while (true) {
            System.out.print("Informe o codigo da pessoa: ");
            entrada = scanner.nextLine();

            if (ValidaCodigoPessoa.codigoValido(entrada)) {
                codpessoa = ValidaCodigoPessoa.converterParaInteiro(entrada);
                break;
            }
        }
        
        if (tipopessoa.equals("F")) {

            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            PessoaFisica pf = pfDao.getPessoa(codpessoa);
            
            if (pf != null) {
                
                // Exibe dados atuais
                pf.exibir();
                
                // Verifica alteracao de nome
                System.out.print("Novo nome: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pf.setNome(entrada);
                }
                
                // Verifica alteracao de logradouro
                System.out.print("Novo logradouro: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pf.setLogradouro(entrada);
                }
           
                // Verifica alteracao de telefone
                System.out.print("Novo telefone: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pf.setTelefone(entrada);
                }
                   
                // Verifica alteracao email
                System.out.print("Novo email: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pf.setEmail(entrada);
                }
                
                // Verifica alteracao de cidade
                System.out.print("Nova cidade: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pf.setCidade(entrada);
                }
                                
                // Verifica alteracao de estado
                System.out.print("Novo estado: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pf.setEstado(entrada);
                }
                    
                // Verifica o CPF
                System.out.print("Novo CPF: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    if (ValidaOpcao.cpfValido(entrada)) {
                        pf.setCpf(entrada.replaceAll("[^0-9]", ""));
                    }
                }
                
                pfDao.alterar(pf);
                
                System.out.println(">>> CONFIRMACAO ==> Pessoa Fisica alterada com sucesso!\n");
            } else {
                System.out.println(">>> ERRO ==> Pessoa Fisica nao encontrada.\n");
            }
        } else {
         
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            PessoaJuridica pj = pjDao.getPessoa(codpessoa);

            if (pj != null) {
                            
                // Exibe dados atuais
                pj.exibir();
                
                // Verifica alteracao de nome
                System.out.print("Novo nome: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pj.setNome(entrada);
                }
                
                // Verifica alteracao de logradouro
                System.out.print("Novo logradouro: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pj.setLogradouro(entrada);
                }
           
                // Verifica alteracao de telefone
                System.out.print("Novo telefone: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pj.setTelefone(entrada);
                }
                   
                // Verifica alteracao email
                System.out.print("Novo email: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pj.setEmail(entrada);
                }
                
                // Verifica alteracao de cidade
                System.out.print("Nova cidade: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pj.setCidade(entrada);
                }
                                
                // Verifica alteracao de estado
                System.out.print("Novo estado: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    pj.setEstado(entrada);
                }
                    
                // Verifica o CNPJ
                System.out.print("Novo CNPJ: ");
                entrada = scanner.nextLine();
                if (entrada != null && !entrada.trim().isEmpty()) {
                    if (ValidaOpcao.cpfValido(entrada)) {
                        pj.setCnpj(entrada.replaceAll("[^0-9]", ""));
                    }
                }
                
                pjDao.alterar(pj);
                
                System.out.println(">>> CONFIRMACAO ==> Pessoa Juridicqa alterada com sucesso!\n");
            } else {
                System.out.println(">>> ERRO ==> Pessoa Juridica nao encontrada.\n");
            }
        }
    }

    // Excluir Pessoas
    
    private static void excluirPessoa(Scanner scanner) {

        String tipopessoa;

        do {
            System.out.print("F - Pessoa Fisica | J - Pessoa Juridica): ");
            tipopessoa = scanner.nextLine();
        } while (!ValidaTipoPessoa.tipoValido(tipopessoa));

        tipopessoa = ValidaTipoPessoa.obterTipo(tipopessoa);

        // Validacao do codigo da pessoa
        
        int codpessoa;
        String entrada;
        
        while (true) {
            System.out.print("Informe o codigo da pessoa: ");
            entrada = scanner.nextLine();

            if (ValidaCodigoPessoa.codigoValido(entrada)) {
                codpessoa = ValidaCodigoPessoa.converterParaInteiro(entrada);
                break;
            }
        }

        // Exclusao de Pessoa Fisica
        
        if (tipopessoa.equals("F")) {
            
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            PessoaFisica pf = pfDao.getPessoa(codpessoa);

            if (pf != null) {

            // Exibe os dados antes da exclusao
                pf.exibir();

                // Confirmacao da Exclusao
                
                String confirmacao;

                do {
                    System.out.print("Deseja realmente excluir esta pessoa? (S/N): ");
                    confirmacao = scanner.nextLine().trim().toUpperCase();
                } while (!confirmacao.equals("S") && !confirmacao.equals("N"));

                if (confirmacao.equals("S")) {
                    pfDao.excluir(codpessoa);
                    System.out.println(">>> CONFIRMACAO ==> Pessoa Juridica excluida com sucesso!\n");
                } else {
                    System.out.println(">>> AVISO ==> Operacao cancelada pelo usuario.\n");
                }
            } else {
                 System.out.println(">>> ERRO ==> Pessoa Fisica nao encontrada.\n");
            }
        } else {

            // Exclusao de Pessoa Juridica
            
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            PessoaJuridica pj = pjDao.getPessoa(codpessoa);

            if (pj != null) {

                // Exibe os dados antes da exclusao

                pj.exibir();  // Mostra dados antes da exclusão

                // Confirmacao da Exclusao
                
                String confirmacao;

                do {
                    System.out.print("Deseja realmente excluir esta pessoa? (S/N): ");
                    confirmacao = scanner.nextLine().trim().toUpperCase();
                } while (!confirmacao.equals("S") && !confirmacao.equals("N"));

                if (confirmacao.equals("S")) {
                    pjDao.excluir(codpessoa);
                    System.out.println(">>> CONFIRMACAO ==> Pessoa Juridica excluida com sucesso!\n");
                } else {
                    System.out.println(">>> AVISO ==> Operacao cancelada pelo usuario.\n");
                }
            } else {
                 System.out.println(">>> ERRO ==> Pessoa Juridica nao encontrada.\n");
            }
        }
    }           
                
    // Exibir Pessoa selecionada por Codigo de Pessoas
    
    private static void exibirPorCodPessoa(Scanner scanner) {

        String tipoPessoa;

        // Solicita e Valida o Tipo de Pessoa
        
        do {
            System.out.print("F - Pessoa Fisica | J - Pessoa Juridica): ");
            tipoPessoa = scanner.nextLine().toUpperCase();
        } while (!ValidaTipoPessoa.tipoValido(tipoPessoa));

        tipoPessoa = ValidaTipoPessoa.obterTipo(tipoPessoa);

        // Solicita e Valida o Codigo de Pessoa
        
        int codpessoa;
        String entrada;

        while (true) {
            System.out.print("Informe o codigo da pessoa: ");
            entrada = scanner.nextLine();
            if (ValidaCodigoPessoa.codigoValido(entrada)) {
                codpessoa = ValidaCodigoPessoa.converterParaInteiro(entrada);
                break;
            }
        }
        
        if (tipoPessoa.equals("F")) {

            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();
            PessoaFisica pf = pfDao.getPessoa(codpessoa);

            if (pf != null) {
                pf.exibir();
            } else {
                System.out.println(">>> ERRO ==> Pessoa Fisica nao encontrada.\n");
            }
        } else {

            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();
            PessoaJuridica pj = pjDao.getPessoa(codpessoa);
            
            if (pj != null) {
                pj.exibir();
            } else {
                System.out.println(">>> ERRO ==> Pessoa Juridica nao encontrada.\n");
            }
        }
    }

    // Exibir TODAS as Pessoas
    
    private static void exibirTodos(Scanner scanner) {

        String tipopessoa;

        do {
            System.out.print("F - Pessoa Fisica | J - Pessoa Juridica): ");
            tipopessoa = scanner.nextLine();
        } while (!ValidaTipoPessoa.tipoValido(tipopessoa));

        tipopessoa = ValidaTipoPessoa.obterTipo(tipopessoa);

        if (tipopessoa.equals("F")) {

            // Lista Todas as Pessoas Fisicas

            PessoaFisicaDAO pfDao = new PessoaFisicaDAO();            
            List<PessoaFisica> pessoas = pfDao.getPessoas();
            for (PessoaFisica pf : pessoas) {
                pf.exibir();
            }
            System.out.println(">>> CONFIRMACAO ==> Final das Pessoas Fisicas.\n");
        } else  {

            // Lista Todas as Pessoas Juridicas
            
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(); 
            List<PessoaJuridica> pessoas = pjDao.getPessoas();
            for (PessoaJuridica pj : pessoas) {
                pj.exibir();
            }
            System.out.println(">>> CONFIRMACAO ==> Final das Pessoas Juridicas.\n");
        }
    }
}
