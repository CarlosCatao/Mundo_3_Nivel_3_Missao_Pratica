/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd.util;

public class ValidaTipoPessoa {

    // Valida se o tipo de pessoa é F ou J (aceita maiusculo ou minusculo)
    public static boolean tipoValido(String entrada) {
        if (entrada == null) {
            System.out.println(">>> ERRO ==> Entrada NULA. Digite F para FIsica ou J para JurIdica.\n");
            return false;
        }

        entrada = entrada.trim().toUpperCase();

        if (entrada.equals("F") || entrada.equals("J")) {
            return true;
        } else {
            System.out.println(">>> ERRO ==> Tipo invalido. Digite F para Fisica ou J para Juidica.\n");
            return false;
        }
    }

    // Retorna o tipo formatado em maiúsculo (F ou J)
    public static String obterTipo(String entrada) {
        return entrada.trim().toUpperCase();
    }
}

