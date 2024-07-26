package me.jiniworld.jpa.user.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private Integer level;
    private Integer active;

    private Address homeAddress;

    @Embedded // Not necessary...
    @AttributeOverride(name = "street",
        column = @Column(name = "BILLING_STREET")) // NULLable!
    @AttributeOverride(name = "zipcode",
        column = @Column(name = "BILLING_ZIPCODE", length = 5))
    @AttributeOverride(name = "city",
        column = @Column(name = "BILLING_CITY"))
    private Address billingAddress;
}
