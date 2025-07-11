package br.com.rodrigoamora.controller.doc;

import br.com.rodrigoamora.dto.PedidoDto;
import br.com.rodrigoamora.dto.StatusDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Endpoints de pedidos")
public interface PedidoApiDoc {

    @Operation(summary = "Listar todos os pedidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listagem de todos os pedidos", content = @Content(schema = @Schema(type = "array", implementation = PedidoDto.class))),
    })
    public List<PedidoDto> listarTodos();

    @Operation(summary = "Buscar pedido por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca de pedido pelo id", content = @Content(schema = @Schema(implementation = PedidoDto.class))),
    })
    public ResponseEntity<PedidoDto> listarPorId(Long id);

    @Operation(summary = "Realizar pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Realização de pedido", content = @Content(schema = @Schema(implementation = PedidoDto.class))),
    })
    public ResponseEntity<PedidoDto> realizaPedido(PedidoDto dto, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualizar status do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização do status pedido pelo id", content = @Content(schema = @Schema(implementation = PedidoDto.class))),
    })
    public ResponseEntity<PedidoDto> atualizaStatus(Long id, StatusDto status);

    @Operation(summary = "Aprovar pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprovação do pagamento do pedido pelo id", content = @Content(schema = @Schema(implementation = PedidoDto.class))),
    })
    public ResponseEntity<Void> aprovaPagamento(Long id);

}
