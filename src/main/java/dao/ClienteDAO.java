package dao;

import java.util.List;
import dominio.Cliente;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    void atualizar(Cliente cliente);
    void remover(Cliente cliente);
}