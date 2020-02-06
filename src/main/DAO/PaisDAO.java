package DAO;

import connection.JDBDCConnection;
import domain.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements DAO<Pais> {
    private Connection conexao;

    public PaisDAO() {
        this.conexao = JDBDCConnection.getConnection();
    }

    @Override
    public void salvar(Pais domain) {

        try {
            String sql = "INSERT INTO pais(nome_pais) VALUES(?)";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1,domain.getNomePais());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void atualizar(Pais domain){

        try {
            String sql = "UPDATE pais SET nome_pais = ? WHERE id_pais = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomePais());
            ps.setInt(2, domain.getIdPais());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deletar(Pais domain){

        try {
            String sql = "DELETE FROM pais WHERE id_pais = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdPais());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public List<Pais> listarTodos(){
        List<Pais> paisList = new ArrayList<Pais>();

        try {
            String sql = "SELECT * FROM pais";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                paisList.add(
                    new Pais(
                        rs.getInt("id_pais"),
                        rs.getString("nome_pais")
                    )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return paisList;
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
