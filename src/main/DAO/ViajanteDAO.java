package DAO;

import connection.JDBDCConnection;
import domain.Viajante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViajanteDAO implements DAO<Viajante> {

    private Connection conexao;

    public ViajanteDAO() {
        this.conexao = JDBDCConnection.getConnection();
    }

    @Override
    public void salvar(Viajante domain) {

        try {
            String sql = "INSERT INTO viajante (nome_viajante, documento_viajante, data_nascimento) VALUES(?,?,?)";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomeViajante());
            ps.setString(2, domain.getDocumentoViajante());
            ps.setDate(3, domain.getData_nascimento());
            ps.execute();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            close();
        }

    }

    @Override
    public void atualizar(Viajante domain) {

        try {
            String sql = "UPDATE viajante SET " +
                         "nome_viajante      = ?, " +
                         "documento_viajante = ?, " +
                         "data_nascimento    = ?  " +
                         "WHERE id_viajante  = ?  ";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomeViajante());
            ps.setString(2, domain.getDocumentoViajante());
            ps.setDate(3, domain.getData_nascimento());
            ps.setInt(4, domain.getIdViajante());
            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deletar(Viajante domain) {

        try {
            String sql = "DELETE FROM viajante WHERE id_viajante = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdViajante());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public List<Viajante> listarTodos() {
        List<Viajante> viajanteList= new ArrayList<Viajante>();

        try {
            String sql = "SELECT * FROM viajante";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                viajanteList.add(
                    new Viajante(
                        rs.getInt("id_viajante"),
                        rs.getString("nome_viajante"),
                        rs.getString("documento_viajante"),
                        rs.getDate("data_nascimento")
                    )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return viajanteList;
    }

    @Override
    public void close() {
        try {
            if(this.conexao != null) {
                this.conexao.close();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
