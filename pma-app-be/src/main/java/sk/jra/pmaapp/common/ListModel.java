package sk.jra.pmaapp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListModel<T> implements Serializable {

  private Integer count;
  private Integer page;
  private Integer pages;
  private Integer limit;
  private List<T> data;
}
