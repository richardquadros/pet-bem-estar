package dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToOne
	private Cliente dono;
	private String especie; 
	private String raca;
	private int idade;
	
	@OneToMany(mappedBy = "pet")
	private List<Agendamento> agendamentos = new ArrayList<>();

	public Pet() {
	}

	public Pet(String nome, Cliente dono, String especie, String raca, int idade) {
		super();
		this.nome = nome;
		this.dono = dono;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
	}



	public void adicionarDono(Cliente dono) {
		this.dono = dono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void adicionarAgendamento(Agendamento agendamento) {
		agendamentos.add(agendamento);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", dono=" + dono + ", especie=" + especie + ", raca=" + raca
				+ ", idade=" + idade + "]";
	}
	
	
	
}
