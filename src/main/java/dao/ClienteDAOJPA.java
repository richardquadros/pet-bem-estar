package dao;

import java.util.List;
import dominio.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDAOJPA implements ClienteDAO {

    private EntityManager em;

    public ClienteDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Cliente cliente) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public void atualizar(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
        em.getTransaction().commit();
    }
}