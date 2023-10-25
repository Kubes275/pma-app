package sk.jra.pmaapp.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ContractBankAccountId implements Serializable {
  private static final long serialVersionUID = -8486021263789639533L;
  @Column(name = "contract_id", nullable = false)
  private Integer contractId;

  @Column(name = "bank_account_id", nullable = false)
  private Integer bankAccountId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ContractBankAccountId entity = (ContractBankAccountId) o;
    return Objects.equals(this.bankAccountId, entity.bankAccountId) &&
           Objects.equals(this.contractId, entity.contractId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankAccountId, contractId);
  }

}