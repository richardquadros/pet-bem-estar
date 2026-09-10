package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;
import java.util.List;

import dao.AgendamentoDAO;
import dao.AgendamentoDAOJPA;
import dao.ClienteDAO;
import dao.ClienteDAOJPA;
import dao.PetDAO;
import dao.PetDAOJPA;
import dominio.Agendamento;
import dominio.Cliente;
import dominio.Pet;
import dominio.SituacaoAgendamento;
import dominio.TipoServico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");
        EntityManager em = emf.createEntityManager();

        ClienteDAO clienteDAO = new ClienteDAOJPA(em);
        PetDAO petDAO = new PetDAOJPA(em);
        AgendamentoDAO agendamentoDAO = new AgendamentoDAOJPA(em);

        Cliente cliente = new Cliente("Carlos Eduardo Lima", "12345678901", "Av. Ipiranga, 1200", "51988887777", "carlos@email.com");
        clienteDAO.salvar(cliente);

        Pet petThor = new Pet("Thor", cliente, "Gato", "Persa", 4);
        petDAO.salvar(petThor);

        Agendamento ag1 = new Agendamento(petThor, SituacaoAgendamento.marcado, TipoServico.consulta, LocalDateTime.now());
        Agendamento ag2 = new Agendamento(petThor, SituacaoAgendamento.marcado, TipoServico.banho, LocalDateTime.now().plusDays(1));
        
        agendamentoDAO.salvar(ag1);
        agendamentoDAO.salvar(ag2);

        cliente.setNome("Carlos Eduardo Lima Alterado");
        clienteDAO.atualizar(cliente);
        System.out.println("Tutor atualizado: " + clienteDAO.buscarPorId(cliente.getId()).getNome());

        agendamentoDAO.remover(ag2);
        System.out.println("Atendimento removido com sucesso!");

        Agendamento ag3 = new Agendamento(petThor, SituacaoAgendamento.marcado, TipoServico.tosa, LocalDateTime.now().plusDays(2));
        agendamentoDAO.salvar(ag3);

        List<Agendamento> atendimentosDoThor = agendamentoDAO.listarPorAnimal(petThor.getId());
        System.out.println("\n--- Atendimentos do Pet " + petThor.getNome() + " ---");
        for (Agendamento a : atendimentosDoThor) {
            System.out.println(a);
        }

        em.close();
        emf.close();
    }
}