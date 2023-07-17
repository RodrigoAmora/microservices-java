package br.com.rodrigoamora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoamora.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
