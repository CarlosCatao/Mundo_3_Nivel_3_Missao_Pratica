/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd.model;

public class Pessoa {
    private int cod_pessoa;
    private String nome;
    private String logradouro;
    private String telefone;
    private String email;
    private String tipo_pessoa;  /* F - fisica  J - juridica */
    private String cidade;
    private String estado;

    public Pessoa() {}

    public Pessoa(int cod_pessoa, String nome, String logradouro, String telefone, String email, String tipo_pessoa, String cidade, String estado) {
        this.cod_pessoa = cod_pessoa;
        this.nome = nome;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.email = email;
        this.tipo_pessoa = tipo_pessoa;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void exibir() {
        System.out.println("Codigo Pessoa: " + cod_pessoa +
                           ", Nome: " + nome +
                           ", Logradouro: " + logradouro +
                           ", Telefone: " + telefone +
                           ", Email: " + email +
                           ", Tipo: " + tipo_pessoa +
                           ", Cidade: " + cidade +
                           ", Estado: " + estado);
    }

        public int getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(int cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
