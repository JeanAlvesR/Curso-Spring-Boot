package io.github.jeanalvesr.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;
}
