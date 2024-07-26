package me.jiniworld.jpa.user.persistence;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Immutable
@Entity
public class TestCode {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Getter private String name;

  @Type(type = "yes_no")
  private boolean verified;

}
