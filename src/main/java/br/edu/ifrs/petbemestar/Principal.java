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
		
		clienteCarlos.adicionarPet(petThor);

		Agendamento agendamentoConsulta = new Agendamento(petThor, SituacaoAgendamento.marcado, TipoServico.consulta, LocalDateTime.of(2026, 9, 15, 10, 30));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(clienteCarlos);
		em.persist(petThor);
		em.persist(agendamentoConsulta);
		
		em.getTransaction().commit();

		em.close();
		emf.close();

		System.out.println("Dados salvos no banco de dados com sucesso!");
	}
}