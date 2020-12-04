package ua.lviv.iot.terminal.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terminal_type", schema = "pavliyk_3")
public class TerminalType {
  private Integer id;
  private String type;

  public TerminalType() {
  }

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TerminalType that = (TerminalType) o;

    if (!id.equals(that.id)) {
      return false;
    }
    return type.equals(that.type);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + type.hashCode();
    return result;
  }
}
