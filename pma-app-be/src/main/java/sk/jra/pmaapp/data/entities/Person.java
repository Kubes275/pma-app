package sk.jra.pmaapp.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person", schema = "pma")
public class Person {
  @Id
  @Column(name = "person_id", nullable = false)
  private Short id;

  @Column(name = "first_name", length = 20)
  private String firstName;

  @Column(name = "surname", length = 20)
  private String surname;

  @Column(name = "phonenumber", length = 20)
  private String phonenumber;

  @Column(name = "email", length = 50)
  private String email;

}