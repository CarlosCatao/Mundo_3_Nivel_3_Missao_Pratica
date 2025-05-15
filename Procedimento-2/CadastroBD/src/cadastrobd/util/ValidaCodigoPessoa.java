/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */
package cadastrobd.util;

public class ValidaCodigoPessoa {

    // Verifica se a entrada e um codigo inteiro valido (positivo)
    public static boolean codigoValido(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            System.out.println(">>> ERRO ==> Codigo nao pode estar vazio.\n");
            return false;
        }

        try {
            int codigo = Integer.parseInt(entrada.trim());
            if (codigo <= 0) {
                System.out.println(">>> ERRO ==> Codigo deve ser um numero inteiro positivo.\n");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println(">>> ERRO ==> Codigo invalido. Digite um numero inteiro valido.\n");
            return false;
        }
    }

    // Converte entrada para inteiro
    public static int converterParaInteiro(String entrada) {
        return Integer.parseInt(entrada.trim());
    }
}

