package br.com.rodrigoamora.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Positive
	private BigDecimal valor;
	
	@NotBlank
	@Size(max=100)
	private String nome;
	
	@NotBlank
	@Size(max=19)
	private String numero;
	
	@NotBlank
	@Size(max=7)
	private String expiracao;
	
	@NotBlank
	@Size(min=3, max=3)
	private String codigo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Long pedidoId;
	
	private Long formaDePagamentoId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getExpiracao() {
		return expiracao;
	}
	
	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Long getFormaDePagamentoId() {
		return formaDePagamentoId;
	}
	
	public void setFormaDePagamentoId(Long formaDePagamentoId) {
		this.formaDePagamentoId = formaDePagamentoId;
	}
	
	public Long getPedidoId() {
		return pedidoId;
	}
	
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	
}
