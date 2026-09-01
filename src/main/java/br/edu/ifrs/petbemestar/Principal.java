package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

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
		Cliente clienteCarlos = new Cliente("Carlos Eduardo Lima", "12345678901", "Av. Ipiranga, 1200", "51988887777", "carlos.lima@email.com");
		
		Pet petThor = new Pet("Thor", clienteCarlos, "Gato", "Persa", 4);
		Pet petLuna = new Pet("Luna", clienteCarlos, "Cão", "Golden Retriever", 2);
		
		clienteCarlos.adicionarPet(petThor);
		clienteCarlos.adicionarPet(petLuna);

		Agendamento agendamentoConsulta = new Agendamento(petThor, SituacaoAgendamento.marcado, TipoServico.consulta, LocalDateTime.of(2026, 9, 15, 10, 30));
		Agendamento agendamentoBanho = new Agendamento(petLuna, SituacaoAgendamento.marcado, TipoServico.banho, LocalDateTime.of(2026, 9, 16, 14, 0));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(clienteCarlos);
		em.persist(petThor);
		em.persist(petLuna);
		em.persist(agendamentoConsulta);
		em.persist(agendamentoBanho);
		
		em.getTransaction().commit();

		em.close();
		emf.close();

		System.out.println("Dados salvos no banco de dados com sucesso!");
	}
}