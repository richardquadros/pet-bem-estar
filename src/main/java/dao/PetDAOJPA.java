package dao;

import java.util.List;
import dominio.Pet;
import jakarta.persistence.EntityManager;

public class PetDAOJPA implements PetDAO {

    private EntityManager em;

    public PetDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Pet pet) {
        em.getTransaction().begin();
        em.persist(pet);
        em.getTransaction().commit();
    }

    @Override
    public Pet buscarPorId(Long id) {
        return em.find(Pet.class, id);
    }

    @Override
    public List<Pet> listarTodos() {
        return em.createQuery("SELECT p FROM Pet p", Pet.class).getResultList();
    }

    @Override
    public void atualizar(Pet pet) {
        em.getTransaction().begin();
        em.merge(pet);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Pet pet) {
        em.getTransaction().begin();
        em.remove(em.contains(pet) ? pet : em.merge(pet));
        em.getTransaction().commit();
    }
}