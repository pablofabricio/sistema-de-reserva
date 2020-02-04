package DAO;

import connection.JDBDCConnection;
import domain.Pais;
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

//        String sql = "INSERT INTO tipo_passeio(nome) VALUES('" + tipo_passeio.getNome() + "');'"; MANEIRA ERRADA ( pode receber mysql injection )
            String sql = "INSERT INTO tipo_passeio(nome_passeio,descricao_passeio) VALUES(?,?)";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1,domain.getNomePasseio());
            ps.setString(2,domain.getDescricaoPasseio());
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
            String sql = "UPDATE tipo_passeio SET nome_passeio = ? , descricao_passeio = ?  WHERE id_tipo_passeio = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomePasseio());
            ps.setString(2,domain.getDescricaoPasseio());
            ps.setInt(3, domain.getIdPais());
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
            String sql = "DELETE FROM tipo_passeio WHERE id_tipo_passeio = ?";
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
        List<Pais> tipoPasseios = new ArrayList<Pais>();
        try {
            String sql = "SELECT * FROM tipo_passeio";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Pais tipoPasseio = new Pais();
                tipoPasseio.setIdPais(rs.getInt("id_tipo_passeio"));
                tipoPasseio.setNomePasseio(rs.getString("nome_passeio"));
                tipoPasseio.setDescricaoPasseio(rs.getString("descricao_passeio"));
                tipoPasseios.add(tipoPasseio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return tipoPasseios;
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
