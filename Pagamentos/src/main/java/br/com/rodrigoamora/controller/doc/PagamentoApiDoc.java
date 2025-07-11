package br.com.rodrigoamora.controller.doc;

import br.com.rodrigoamora.dto.PagamentoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Endpoints de pagamentos")
public interface PagamentoApiDoc {

    @Operation(summary = "Listar pagamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de pagamentos", content = @Content(schema = @Schema(type = "array", implementation = PagamentoDto.class))),
    })
    public Page<PagamentoDto> listar(Pageable paginacao);

    @Operation(summary = "Detalhar pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exibir detalhes do pagamento", content = @Content(schema = @Schema(implementation = PagamentoDto.class))),
    })
    public ResponseEntity<PagamentoDto> detalhar(Long id);

    @Operation(summary = "Cadastrar pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastrar um pagamento", content = @Content(schema = @Schema(implementation = PagamentoDto.class))),
    })
    public ResponseEntity<PagamentoDto> cadastrar(PagamentoDto dto,
                                                  UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualizar pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizar um pagamento pelo id", content = @Content(schema = @Schema(implementation = PagamentoDto.class))),
    })
    public ResponseEntity<PagamentoDto> atualizar(Long id, PagamentoDto dto);

    @Operation(summary = "Remover pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Remover um pagamento peelo id", content = @Content(schema = @Schema(implementation = PagamentoDto.class))),
    })
    public ResponseEntity<PagamentoDto> remover(Long id);

    @Operation(summary = "Confirmar pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Confirmar um pagamento peelo id", content = @Content(schema = @Schema(implementation = PagamentoDto.class))),
    })
    public void confirmarPagamento(Long id);

}
