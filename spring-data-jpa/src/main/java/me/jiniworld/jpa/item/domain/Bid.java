package me.jiniworld.jpa.item.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Bid {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @NotNull
    private BigDecimal amount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) // NOT NULL
    @JoinColumn(name = "ITEM_ID") // Actually the default name
    private Item item;
}
