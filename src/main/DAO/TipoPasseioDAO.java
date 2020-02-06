package DAO;

import connection.JDBDCConnection;
import domain.TipoPasseio;
import domain.TipoPasseio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoPasseioDAO implements DAO<TipoPasseio> {

    private Connection conexao;

    public TipoPasseioDAO() {
        this.conexao = JDBDCConnection.getConnection();
    }

    @Override
    public void salvar(TipoPasseio domain) {

        try {
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
    public void atualizar(TipoPasseio domain){

        try {
            String sql = "UPDATE tipo_passeio SET nome_passeio = ? , descricao_passeio = ?  WHERE id_tipo_passeio = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomePasseio());
            ps.setString(2,domain.getDescricaoPasseio());
            ps.setInt(3, domain.getIdTipoPasseio());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void deletar(TipoPasseio domain){

        try {
            String sql = "DELETE FROM tipo_passeio WHERE id_tipo_passeio = ?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdTipoPasseio());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public List<TipoPasseio> listarTodos(){
        List<TipoPasseio> tipoPasseios = new ArrayList<TipoPasseio>();

        try {
            String sql = "SELECT * FROM tipo_passeio";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                tipoPasseios.add(
                    new TipoPasseio(rs.getInt("id_tipo_passeio"),
                            rs.getString("nome_passeio"),
                            rs.getString("descricao_passeio")
                    )
                );
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
