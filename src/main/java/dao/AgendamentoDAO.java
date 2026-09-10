package dao;

import java.util.List;
import dominio.Agendamento;

public interface AgendamentoDAO {
    void salvar(Agendamento agendamento);
    Agendamento buscarPorId(Long id);
    List<Agendamento> listarTodos();
    void atualizar(Agendamento agendamento);
    void remover(Agendamento agendamento);
    
}