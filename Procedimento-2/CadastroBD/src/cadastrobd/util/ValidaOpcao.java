/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd.util;

public class ValidaOpcao {

    // Valida se a entrada é um número dentro do intervalo
    public static boolean validaOpcao(String entrada, int minimo, int maximo) {
        if (entrada == null || entrada.trim().isEmpty()) {
            System.out.println(">>> ERRO ==> Opcao NULA. Digite um numero entre " + minimo + " e " + maximo + ".\n");
            return false;
        }
        try {
            int opcao = Integer.parseInt(entrada.trim());
            if (opcao < minimo || opcao > maximo) {
                System.out.println(">>> ERRO ==> Opcao fora do intervalo permitido (" + minimo + " a " + maximo + ").\n");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println(">>> ERRO ==> Entrada invalida! Digite um numero valido.\n");
            return false;
        }
    }

    // Converte para int após validação
    public static int converterParaInteiro(String entrada) {
        return Integer.parseInt(entrada);
    }

    // Verifica se string não está vazia ou nula
    public static boolean stringValida(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            System.out.println(">>> ERRO ==> O campo nao pode estar vazio.\n");
            return false;
        }
        return true;
    }

    // Confirmação positiva (S, SIM)
    public static boolean confirmarSim(String entrada) {
        if (entrada == null) return false;
        entrada = entrada.trim().toUpperCase();
        return entrada.equals("S") || entrada.equals("SIM");
    }

    // Confirmação negativa (N, NAO, NÃO)
    public static boolean confirmarNao(String entrada) {
        if (entrada == null) return false;
        entrada = entrada.trim().toUpperCase();
        return entrada.equals("N") || entrada.equals("NAO") || entrada.equals("NÃO");
    }
 
    // Validacao de CPF
    public static boolean cpfValido(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
          System.out.println(">>> ERRO ==> CPF nao pode estar vazio.\n");
          return false;
        }

        cpf = cpf.replaceAll("[^0-9]", ""); // remove pontos e traços

        if (cpf.length() != 11) {
          System.out.println(">>> ERRO ==> CPF deve conter 11 digitos numericos.");
          return false;
        }

        return true;
    }

    // Validacao de CPF

    public static boolean cnpjValido(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()) {
            System.out.println(">>> ERRO ==> O CNPJ nao pode estar vazio.\n");
            return false;
        }

        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            System.out.println(">>> ERRO ==> O CNPJ deve conter 14 digitos numericos.\n");
            return false;
        }

        return true;
    }
}
