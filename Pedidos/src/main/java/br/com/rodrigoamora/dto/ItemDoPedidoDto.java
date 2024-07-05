package br.com.rodrigoamora.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemDoPedidoDto {

	@JsonIgnore
    private Long id;
    private Integer quantidade;
    private String descricao;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
