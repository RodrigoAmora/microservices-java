package br.com.rodrigoamora.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.rodrigoamora.model.Status;

public class PedidoDto {

    private Long id;
    private LocalDateTime dataHora;
    private Status status;
    private List<ItemDoPedidoDto> itens = new ArrayList<>();
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<ItemDoPedidoDto> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemDoPedidoDto> itens) {
		this.itens = itens;
	}
    
}
