package dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Pet pet;
	
	@Enumerated(EnumType.STRING)
	private SituacaoAgendamento situacaoAgendamento;
	
	@Enumerated(EnumType.STRING)
	private TipoServico tipoServico;
	private LocalDateTime horario;
	
	public Agendamento(){};
	
	public Agendamento(Pet pet, SituacaoAgendamento situacaoAgendamento, TipoServico tipoServico,
			LocalDateTime horario) {
		super();
		this.pet = pet;
		this.situacaoAgendamento = situacaoAgendamento;
		this.tipoServico = tipoServico;
		this.horario = horario;
		pet.adicionarAgendamento(this);
	}


	public Pet getPet() {
		return pet;
	}


	public void setPet(Pet pet) {
		this.pet = pet;
	}


	public SituacaoAgendamento getSituacaoAgendamento() {
		return situacaoAgendamento;
	}


	public void setSituacaoAgendamento(SituacaoAgendamento situacaoAgendamento) {
		this.situacaoAgendamento = situacaoAgendamento;
	}


	public TipoServico getTipoServico() {
		return tipoServico;
	}


	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}


	public LocalDateTime getHorario() {
		return horario;
	}


	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", pet=" + pet + ", situacaoAgendamento=" + situacaoAgendamento
				+ ", tipoServico=" + tipoServico + ", horario=" + horario + "]";
	}

	
	
}
