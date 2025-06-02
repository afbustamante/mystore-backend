package net.andresbustamante.mystore.api.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderSearchCriteria {

    private LocalDate dateMin;
    private LocalDate dateMax;
}
