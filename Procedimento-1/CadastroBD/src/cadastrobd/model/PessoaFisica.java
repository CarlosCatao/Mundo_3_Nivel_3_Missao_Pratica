/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd.model;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica() {
        super();
        setTipo_pessoa("F");
    }

    public PessoaFisica(int cod_pessoa, String nome, String logradouro, String telefone, String email, String cidade, String estado, String cpf) {
        super(cod_pessoa, nome, logradouro, telefone, email, "F", cidade, estado);
        this.cpf = cpf;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
