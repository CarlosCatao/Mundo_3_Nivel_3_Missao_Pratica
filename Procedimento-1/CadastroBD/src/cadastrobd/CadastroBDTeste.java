/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd;

import cadastrobd.model.*;

import java.util.List;

public class CadastroBDTeste {
    public static void main(String[] args) {

        // Pessoa Fisica

        PessoaFisicaDAO pfDao = new PessoaFisicaDAO();

        // Pessoa Fisica - Lista Cadastro Atual

        System.out.println("--- Listando Pessoas Fisicas (Inicio) ---");
        List<PessoaFisica> pessoasFisicas = pfDao.getPessoas();
        for (PessoaFisica pessoa : pessoasFisicas) {
            pessoa.exibir();
        }

        // Pessoa Fisica - Inclusao de Nova Pessoa

        System.out.println("--- Inserindo Pessoa Fisica ---");
        System.out.println("Jose das Couves / Rua Exo / 123456789 / jose@email.com / Belo Horizonte / MG / 12345678900");

        PessoaFisica pf = new PessoaFisica(0, "Jose das Couves", "Rua Exo", "123456789", "jose@email.com", "Belo Horizonte", "MG", "12345678900");
        pfDao.incluir(pf);

        // Pessoa Fisica - Captura do ID para futura exclusao

        int idPf = pf.getCod_pessoa();

        // Pessoa Fisica - Lista Cadastro com a Inclusao

        System.out.println("--- Listando Pessoas Fisicas (Apos Inclusao) ---");
        pessoasFisicas = pfDao.getPessoas();
        for (PessoaFisica pessoa : pessoasFisicas) {
            pessoa.exibir();
        }

        // Pessoa Fisica - Alteracao na Pessoa incluida - nome e e-mail

        System.out.println("--- Alterando Pessoa Fisica ---");
        System.out.println("nome = Jose das Couves Alterado / e-mail = jose.alterado@email.com");

        pf.setNome("Jose das Couves Alterado");
        pf.setEmail("jose.alterado@email.com");
        pfDao.alterar(pf);

        // Pessoa Fisica - Lista Cadastro com a Alteracao

        System.out.println("--- Listando Pessoas Fisicas (Apos Alteracao) ---");
        pessoasFisicas = pfDao.getPessoas();
        for (PessoaFisica pessoa : pessoasFisicas) {
            pessoa.exibir();
        }

        // Pessoa Fisica - Exclusao da Pessoa incluida

        System.out.println("--- Excluindo Pessoa Fisica ---");
        System.out.println("Codigo pessoa a excluir = ");
        System.out.println(idPf);

        pfDao.excluir(idPf);

        // Pessoa Fisica - Lista Cadastro apos a Exclusao

        System.out.println("--- Listando Pessoas Fisicas (Apos Exclusao) ---");
        pessoasFisicas = pfDao.getPessoas();
        for (PessoaFisica pessoa : pessoasFisicas) {
            pessoa.exibir();
        }

        // Pessoa Juridica

        PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO();

        // Pessoa Juridica - Lista Cadastro Atual

        System.out.println("--- Listando Pessoas Juridicas (Inicio) ---");
        List<PessoaJuridica> pessoasJuridicas = pjDao.getPessoas();
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            pessoa.exibir();
        }

        // Pessoa Juridica - Inclusao de Nova Pessoa

        System.out.println("--- Inserindo Pessoa Juridica ---");
        System.out.println("Empresa X / Av. Central / 987654321 / contato@empresax.com / Sao Paulo / SP / 12345678000190");

        PessoaJuridica pj = new PessoaJuridica(0, "Empresa X Ltda", "Av. Central", "987654321", "contato@empresax.com", "Sao Paulo", "SP", "12345678000190");
        pjDao.incluir(pj);

        // Pessoa Juridica - Captura do ID para futura exclusao

        int idPj = pj.getCod_pessoa();

        // Pessoa Juridica - Lista Cadastro com a Inclusao

        System.out.println("--- Listando Pessoas Juridicas (Apos Inclusao) ---");
        pessoasJuridicas = pjDao.getPessoas();
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            pessoa.exibir();
        }

        // Pessoa Juridica - Alteracao na Pessoa incluida - e-mail e telefone

        System.out.println("--- Alterando Pessoa Juridica ---");
        System.out.println("e-mail = contato@empresaalt.com / telefone = 287621121");

        pj.setTelefone("287621121");
        pj.setEmail("contato@empresaalt.com");
        pjDao.alterar(pj);

        // Pessoa Juridica - Lista Cadastro com a Alteracao

        System.out.println("--- Listando Pessoas Juridicas (Apos Alteracao)---");
        pessoasJuridicas = pjDao.getPessoas();
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            pessoa.exibir();
        }

        // Pessoa Juridica - Exclusao da Pessoa incluida

        System.out.println("--- Excluindo Pessoa Juridica ---");
        System.out.println("Codigo pessoa a excluir = ");
        System.out.println(idPj);

        pjDao.excluir(idPj);

        // Pessoa Juridica - Lista Cadastro apos a Exclusao

        System.out.println("--- Listando Pessoas Juridicas (Apos Exclusao) ---");
        pessoasJuridicas = pjDao.getPessoas();
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            pessoa.exibir();
        }

    }
}




