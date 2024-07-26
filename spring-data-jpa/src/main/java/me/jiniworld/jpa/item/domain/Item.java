package me.jiniworld.jpa.item.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    /*
       The <code>@Access(AccessType.PROPERTY)</code> setting on the <code>name</code> field switches this
       particular property to runtime access through getter/setter methods by the JPA provider.
    */
    @Access(AccessType.PROPERTY)
    @Column(name = "ITEM_NAME") // Mappings are still expected here!
    private String name;

    @OneToMany(mappedBy = "item",
        cascade = CascadeType.PERSIST,
        orphanRemoval = true) // Includes CascadeType.REMOVE
    private Set<Bid> bids = new HashSet<>();

    @Basic(fetch = FetchType.LAZY, optional = false)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING) // Defaults to ORDINAL
    private AuctionType auctionType = AuctionType.HIGHEST_BID;

    @Formula(
        "CONCAT(SUBSTR(DESCRIPTION, 1, 12), '...')"
    )
    private String shortDescription;

    @Formula(
        "(SELECT AVG(B.AMOUNT) FROM BID B WHERE B.ITEM_ID = ID)"
    )
    private BigDecimal averageBidAmount;

    @Column(name = "IMPERIALWEIGHT")
    @ColumnTransformer(
        read = "IMPERIALWEIGHT / 2.20462",
        write = "? * 2.20462"
    )
    private double metricWeight;

    @CreationTimestamp
    private LocalDate createdOn;

    @UpdateTimestamp
    private LocalDateTime lastModified;

    @Column(insertable = false)
    @ColumnDefault("1.00")
    @Generated(
        org.hibernate.annotations.GenerationTime.INSERT
    )
    private BigDecimal initialPrice;

    public void setName(String name) {
        this.name =
            !name.startsWith("AUCTION: ") ? "AUCTION: " + name : name;
    }
}
