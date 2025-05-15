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

public class PessoaJuridicaDAO {

    public PessoaJuridica getPessoa(int cod_pessoa) {
        PessoaJuridica pj = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT p.cod_pessoa, p.nome, p.logradouro, p.telefone, p.email, p.tipo_pessoa, p.cidade, p.estado, pj.cnpj " +
                         "FROM Pessoa p JOIN Pessoa_Juridica pj ON p.cod_pessoa = pj.cod_pessoa WHERE p.tipo_pessoa = 'J'";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cod_pessoa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pj = new PessoaJuridica();
                pj.setCod_pessoa(rs.getInt("cod_pessoa"));
                pj.setNome(rs.getString("nome"));
                pj.setLogradouro(rs.getString("logradouro"));
                pj.setTelefone(rs.getString("telefone"));
                pj.setEmail(rs.getString("email"));
                pj.setTipo_pessoa(rs.getString("tipo_pessoa"));
                pj.setCidade(rs.getString("cidade"));
                pj.setEstado(rs.getString("estado"));
                pj.setCnpj(rs.getString("cnpj"));
            }

        } catch (SQLException e) {
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return pj;
    }

    // Lista as Pessoas Juridicas
    
    public List<PessoaJuridica> getPessoas() {
        List<PessoaJuridica> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConectorBD.getConnection();
            String sql = "SELECT p.cod_pessoa, p.nome, p.logradouro, p.telefone, p.email, p.tipo_pessoa, p.cidade, p.estado, pj.cnpj " +
                         "FROM Pessoa p JOIN Pessoa_Juridica pj ON p.cod_pessoa = pj.cod_pessoa";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pj = new PessoaJuridica();
                pj.setCod_pessoa(rs.getInt("cod_pessoa"));
                pj.setNome(rs.getString("nome"));
                pj.setLogradouro(rs.getString("logradouro"));
                pj.setTelefone(rs.getString("telefone"));
                pj.setEmail(rs.getString("email"));
                pj.setTipo_pessoa(rs.getString("tipo_pessoa"));
                pj.setCidade(rs.getString("cidade"));
                pj.setEstado(rs.getString("estado"));
                pj.setCnpj(rs.getString("cnpj"));
                lista.add(pj);
            }

        } catch (SQLException e) {
        } finally {
            ConectorBD.close(rs);
            ConectorBD.close(stmt);
            ConectorBD.close(conn);
        }

        return lista;
    }

    // Inclue Pessoas Juridicas
    
    public void incluir(PessoaJuridica pj) {
        Connection conn = null;
        PreparedStatement stmtPessoa = null;
        PreparedStatement stmtPJ = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);
            
            int cod_pessoa = SequenceManager.getValue("seq_pessoa");

            pj.setCod_pessoa(cod_pessoa);

            String sqlPessoa = "INSERT INTO Pessoa (cod_pessoa, nome, logradouro, telefone, email, tipo_pessoa, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmtPessoa = conn.prepareStatement(sqlPessoa);
            stmtPessoa.setInt(1, pj.getCod_pessoa());
            stmtPessoa.setString(2, pj.getNome());
            stmtPessoa.setString(3, pj.getLogradouro());
            stmtPessoa.setString(4, pj.getTelefone());
            stmtPessoa.setString(5, pj.getEmail());
            stmtPessoa.setString(6, pj.getTipo_pessoa());
            stmtPessoa.setString(7, pj.getCidade());
            stmtPessoa.setString(8, pj.getEstado());
            stmtPessoa.executeUpdate();

            String sqlPJ = "INSERT INTO Pessoa_Juridica (cod_pessoa, cnpj) VALUES (?, ?)";
            stmtPJ = conn.prepareStatement(sqlPJ);
            stmtPJ.setInt(1, pj.getCod_pessoa());
            stmtPJ.setString(2, pj.getCnpj());
            stmtPJ.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {
              ex.printStackTrace();  
            }
        } finally {
            ConectorBD.close(stmtPJ);
            ConectorBD.close(stmtPessoa);
            ConectorBD.close(conn);
        }
    }

    // Altera Pessoas Juridicas
    
    public void alterar(PessoaJuridica pj) {
        Connection conn = null;
        PreparedStatement stmtPessoa = null;
        PreparedStatement stmtPJ = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);

            String sqlPessoa = "UPDATE Pessoa SET nome = ?, logradouro = ?, telefone = ?, email = ?, tipo_pessoa = ?, cidade = ?, estado = ? WHERE cod_pessoa = ?";
            stmtPessoa = conn.prepareStatement(sqlPessoa);
            stmtPessoa.setString(1, pj.getNome());
            stmtPessoa.setString(2, pj.getLogradouro());
            stmtPessoa.setString(3, pj.getTelefone());
            stmtPessoa.setString(4, pj.getEmail());
            stmtPessoa.setString(5, pj.getTipo_pessoa());
            stmtPessoa.setString(6, pj.getCidade());
            stmtPessoa.setString(7, pj.getEstado());
            stmtPessoa.setInt(8, pj.getCod_pessoa());
            stmtPessoa.executeUpdate();

            String sqlPJ = "UPDATE Pessoa_Juridica SET cnpj = ? WHERE cod_pessoa = ?";
            stmtPJ = conn.prepareStatement(sqlPJ);
            stmtPJ.setString(1, pj.getCnpj());
            stmtPJ.setInt(2, pj.getCod_pessoa());
            stmtPJ.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
        } finally {
            ConectorBD.close(stmtPJ);
            ConectorBD.close(stmtPessoa);
            ConectorBD.close(conn);
        }
    }

    // Exclue Pessoas Juridicas
    
    public void excluir(int cod_pessoa) {
        Connection conn = null;
        PreparedStatement stmtPJ = null;
        PreparedStatement stmtPessoa = null;

        try {
            conn = ConectorBD.getConnection();
            conn.setAutoCommit(false);

            stmtPJ = conn.prepareStatement("DELETE FROM Pessoa_Juridica WHERE cod_pessoa = ?");
            stmtPJ.setInt(1, cod_pessoa);
            stmtPJ.executeUpdate();

            stmtPessoa = conn.prepareStatement("DELETE FROM Pessoa WHERE cod_pessoa = ?");
            stmtPessoa.setInt(1, cod_pessoa);
            stmtPessoa.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
        } finally {
            ConectorBD.close(stmtPJ);
            ConectorBD.close(stmtPessoa);
            ConectorBD.close(conn);
        }
    }
}
