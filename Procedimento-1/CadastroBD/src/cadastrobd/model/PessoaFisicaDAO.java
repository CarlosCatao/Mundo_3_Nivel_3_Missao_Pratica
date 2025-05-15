/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastrobd.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cadastro.model.util.*;

public class PessoaFisicaDAO {

    public PessoaFisica getPessoa(int cod_pessoa) {
        PessoaFisica pf = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT p.cod_pessoa, p.nome, p.logradouro, p.telefone, p.email, p.tipo_pessoa, p.cidade, p.estado, pf.cpf " +
                         "FROM Pessoa p JOIN Pessoa_Fisica pf ON p.cod_pessoa = pf.cod_pessoa WHERE p.tipo_pessoa = 'F'";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cod_pessoa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pf = new PessoaFisica();
                pf.setCod_pessoa(rs.getInt("cod_pessoa"));
                pf.setNome(rs.getString("nome"));
                pf.setLogradouro(rs.getString("logradouro"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setEmail(rs.getString("email"));
                pf.setTipo_pessoa(rs.getString("tipo_pessoa"));
                pf.setCidade(rs.getString("cidade"));
                pf.setEstado(rs.getString("estado"));
                pf.setCpf(rs.getString("cpf"));
            }

        } catch (SQLException e) {
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return pf;
    }

    // Lista as Pessoas Fisicas
    
    public List<PessoaFisica> getPessoas() {
        List<PessoaFisica> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT p.cod_pessoa, p.nome, p.logradouro, p.telefone, p.email, p.tipo_pessoa, p.cidade, p.estado, pf.cpf " +
                         "FROM Pessoa p JOIN Pessoa_Fisica pf ON p.cod_pessoa = pf.cod_pessoa";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pf = new PessoaFisica();
                pf.setCod_pessoa(rs.getInt("cod_pessoa"));
                pf.setNome(rs.getString("nome"));
                pf.setLogradouro(rs.getString("logradouro"));
                pf.setTelefone(rs.getString("telefone"));
                pf.setEmail(rs.getString("email"));
                pf.setTipo_pessoa(rs.getString("tipo_pessoa"));
                pf.setCidade(rs.getString("cidade"));
                pf.setEstado(rs.getString("estado"));
                pf.setCpf(rs.getString("cpf"));
                lista.add(pf);
            }

        } catch (SQLException e) {
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return lista;
    }

    // Inclue Pessoas Fiscas
    
    public void incluir(PessoaFisica pf) {
        Connection conn = null;
        PreparedStatement stmtPessoa = null;
        PreparedStatement stmtPF = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);

            int cod_pessoa = SequenceManager.getValue("seq_pessoa");
/*          
            // Linhas inseridas para Depuracao
            System.out.println("Codigo pessoa gerado = ");
            System.out.println(cod_pessoa);
*/
            pf.setCod_pessoa(cod_pessoa);

            String sqlPessoa = "INSERT INTO Pessoa (cod_pessoa, nome, logradouro, telefone, email, tipo_pessoa, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmtPessoa = conn.prepareStatement(sqlPessoa);
            stmtPessoa.setInt(1, pf.getCod_pessoa());
            stmtPessoa.setString(2, pf.getNome());
            stmtPessoa.setString(3, pf.getLogradouro());
            stmtPessoa.setString(4, pf.getTelefone());
            stmtPessoa.setString(5, pf.getEmail());
            stmtPessoa.setString(6, pf.getTipo_pessoa());
            stmtPessoa.setString(7, pf.getCidade());
            stmtPessoa.setString(8, pf.getEstado());
            stmtPessoa.executeUpdate();

            String sqlPF = "INSERT INTO Pessoa_Fisica (cod_pessoa, cpf) VALUES (?, ?)";
            stmtPF = conn.prepareStatement(sqlPF);
            stmtPF.setInt(1, pf.getCod_pessoa());
            stmtPF.setString(2, pf.getCpf());
            stmtPF.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {
            ex.printStackTrace();
            }
        } finally {
            ConectorBD.close(stmtPF);
            ConectorBD.close(stmtPessoa);
            ConectorBD.close(conn);
        }
    }

    // Altera Pessoas Fiscas
    
    public void alterar(PessoaFisica pf) {
        Connection conn = null;
        PreparedStatement stmtPessoa = null;
        PreparedStatement stmtPF = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);

            String sqlPessoa = "UPDATE Pessoa SET nome = ?, logradouro = ?, telefone = ?, email = ?, tipo_pessoa = ?, cidade = ?, estado = ? WHERE cod_pessoa = ?";
            stmtPessoa = conn.prepareStatement(sqlPessoa);
            stmtPessoa.setString(1, pf.getNome());
            stmtPessoa.setString(2, pf.getLogradouro());
            stmtPessoa.setString(3, pf.getTelefone());
            stmtPessoa.setString(4, pf.getEmail());
            stmtPessoa.setString(5, pf.getTipo_pessoa());
            stmtPessoa.setString(6, pf.getCidade());
            stmtPessoa.setString(7, pf.getEstado());
            stmtPessoa.setInt(8, pf.getCod_pessoa());
            stmtPessoa.executeUpdate();

            String sqlPF = "UPDATE Pessoa_Fisica SET cpf = ? WHERE cod_pessoa = ?";
            stmtPF = conn.prepareStatement(sqlPF);
            stmtPF.setString(1, pf.getCpf());
            stmtPF.setInt(2, pf.getCod_pessoa());
            stmtPF.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
        } finally {
            ConectorBD.close(stmtPF);
            ConectorBD.close(stmtPessoa);
            ConectorBD.close(conn);
        }
    }

    // Exclue Pessoas Fisicas
    
    public void excluir(int cod_pessoa) {
        Connection conn = null;
        PreparedStatement stmtPF = null;
        PreparedStatement stmtPessoa = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);

            stmtPF = conn.prepareStatement("DELETE FROM Pessoa_Fisica WHERE cod_pessoa = ?");
            stmtPF.setInt(1, cod_pessoa);
            stmtPF.executeUpdate();

            stmtPessoa = conn.prepareStatement("DELETE FROM Pessoa WHERE cod_pessoa = ?");
            stmtPessoa.setInt(1, cod_pessoa);
            stmtPessoa.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
        } finally {
            ConectorBD.close(stmtPF);
            ConectorBD.close(stmtPessoa);
            ConectorBD.close(conn);
        }
    }
}
