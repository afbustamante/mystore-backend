package net.andresbustamante.mystore.core.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class OrderItemId implements Serializable {

    @Serial
    private static final long serialVersionUID = 2085276242085969759L;

    @NotNull
    @Column(name = "order_item_id", nullable = false)
    private Short itemId;

    @NotNull
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderItemId that)) {
            return false;
        }
        return Objects.equals(itemId, that.itemId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId);
    }

}
