package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    public void salvar(T domain);

    public void atualizar(T domain);

    public void deletar(T domain);

    public List<T> listarTodos();

    public void close();
}
