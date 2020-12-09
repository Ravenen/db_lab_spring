package ua.lviv.iot.terminal.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country", schema = "pavliyk_3")
public class Country implements Serializable {
  private Integer id;
  private String name;

  public Country() {
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
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Country that = (Country) o;

    if (!id.equals(that.id)) {
      return false;
    }
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "CountryEntity{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
