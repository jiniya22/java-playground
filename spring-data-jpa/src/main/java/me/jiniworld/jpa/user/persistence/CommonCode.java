package me.jiniworld.jpa.user.persistence;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Getter
@Setter
@Immutable
@Entity
public class CommonCode {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Getter private String code;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  private String description;

}
