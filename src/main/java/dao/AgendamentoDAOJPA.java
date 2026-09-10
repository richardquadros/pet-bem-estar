package dao;

import java.util.List;
import dominio.Agendamento;
import dominio.SituacaoAgendamento;
import jakarta.persistence.EntityManager;

public class AgendamentoDAOJPA implements AgendamentoDAO {

    private EntityManager em;

    public AgendamentoDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Agendamento agendamento) {
        em.getTransaction().begin();
        em.persist(agendamento);
        em.getTransaction().commit();
    }

    @Override
    public Agendamento buscarPorId(Long id) {
        return em.find(Agendamento.class, id);
    }

    @Override
    public List<Agendamento> listarTodos() {
        return em.createQuery("SELECT a FROM Agendamento a", Agendamento.class).getResultList();
    }

    @Override
    public void atualizar(Agendamento agendamento) {
        em.getTransaction().begin();
        em.merge(agendamento);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Agendamento agendamento) {
        em.getTransaction().begin();
        em.remove(em.contains(agendamento) ? agendamento : em.merge(agendamento));
        em.getTransaction().commit();
    }

    @Override
    public List<Agendamento> listarPorAnimal(Long idAnimal) {
        String jpql = "SELECT a FROM Agendamento a WHERE a.pet.id = :idAnimal";
        return em.createQuery(jpql, Agendamento.class)
                 .setParameter("idAnimal", idAnimal)
                 .getResultList();
    }

    @Override
    public List<Agendamento> listarPorSituacao(SituacaoAgendamento situacao) {
        String jpql = "SELECT a FROM Agendamento a WHERE a.situacaoAgendamento = :situacao";
        return em.createQuery(jpql, Agendamento.class)
                 .setParameter("situacao", situacao)
                 .getResultList();
    }
}