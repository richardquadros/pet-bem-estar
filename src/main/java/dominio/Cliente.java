package dominio;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String celular;
	private String email;
	
	@OneToMany(mappedBy = "dono")
	private List<Pet> pets = new ArrayList<>();

	public Cliente() {};

	public Cliente(String nome, String cpf, String endereco, String celular, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.celular = celular;
		this.email = email;
	}

	public void adicionarPet(Pet pet) {
		pets.add(pet);
		pet.adicionarDono(this);
	};

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", celular=" + celular + ", email=" + email + ", pets=" + pets
				+ "]";
	}

	
}
