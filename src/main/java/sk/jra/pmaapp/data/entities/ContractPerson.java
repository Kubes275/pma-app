package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@IdClass(ContactPersonId.class)
@Table(name = "contract_person", schema = "pma")
public class ContractPerson {

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contract_id")
  private Contract contract;

  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class ContactPersonId implements Serializable {
  private Long contract;
  private Long person;
}

