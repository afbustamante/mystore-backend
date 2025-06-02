package net.andresbustamante.mystore.web.dto.v1;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Integer id;

    private LocalDate date;

    @JsonProperty("net_amount")
    private BigDecimal netAmount;

    private BigDecimal tax;

    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    @JsonProperty("customer_id")
    private Integer customerId;
}
