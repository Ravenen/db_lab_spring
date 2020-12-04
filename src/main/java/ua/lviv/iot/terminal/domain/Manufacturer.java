package ua.lviv.iot.terminal.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer", schema = "pavliyk_3")
public class Manufacturer {
  private Integer id;
  private String name;
  private String contactNumber;
  private Country countryByCountryId;

  public Manufacturer() {
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

  @Basic
  @Column(name = "contact_number")
  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Manufacturer that = (Manufacturer) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!name.equals(that.name)) {
      return false;
    }
    if (!contactNumber.equals(that.contactNumber)) {
      return false;
    }
    return countryByCountryId.equals(that.countryByCountryId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + contactNumber.hashCode();
    result = 31 * result + countryByCountryId.hashCode();
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  public Country getCountryByCountryId() {
    return countryByCountryId;
  }

  public void setCountryByCountryId(Country countryByCountryId) {
    this.countryByCountryId = countryByCountryId;
  }
}
