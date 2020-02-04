package DAO;


import connection.JDBDCConnection;
import domain.Modalidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModalidadeDAO implements DAO<Modalidade> {
    private Connection conexao;

    public ModalidadeDAO() {
        this.conexao = JDBDCConnection.getConnection();
    }

    @Override
    public void salvar(Modalidade domain) {
       try {

//        String sql = "INSERT INTO modalidade(nome) VALUES('" + modalidade.getNome() + "');'"; MANEIRA ERRADA ( pode receber mysql injection )
           String sql = "INSERT INTO modalidade(nome) VALUES(?)";
           PreparedStatement ps = this.conexao.prepareStatement(sql);
           ps.setString(1,domain.getNome());
           ps.execute();
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           close();
       }
    }

    @Override
    public void atualizar(Modalidade domain){
        try {
            String sql = "UPDATE modalidade SET nome = ? WHERE id_modalidade = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, domain.getNome());
            ps.setInt(2, domain.getIdModalidade());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deletar(Modalidade domain){
        try {
            String sql = "DELETE FROM modalidade WHERE id_modalidade = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdModalidade());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public List<Modalidade> listarTodos(){
        List<Modalidade> modalidades = new ArrayList<Modalidade>();
        try {
            String sql = "SELECT * FROM modalidade";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Modalidade modalidade = new Modalidade();
                modalidade.setIdModalidade(rs.getInt("id_modalidade"));
                modalidade.setNome(rs.getString("nome"));
                modalidades.add(modalidade);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return modalidades;
    }

    @Override
    public void close() {
        if(this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
