package dao;

import java.util.List;
import dominio.Agendamento;
import dominio.SituacaoAgendamento;

public interface AgendamentoDAO {
    void salvar(Agendamento agendamento);
    Agendamento buscarPorId(Long id);
    List<Agendamento> listarTodos();
    void atualizar(Agendamento agendamento);
    void remover(Agendamento agendamento);
    public List<Agendamento> listarPorAnimal(Long idAnimal);
    public List<Agendamento> listarPorSituacao(SituacaoAgendamento situacao);
}