package ua.lviv.iot.terminal.domain;

import java.util.Objects;
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
@Table(name = "city", schema = "pavliyk_3")
public class City {
  private Integer id;
  private String name;
  private String postalCode;
  private Country countryByCountryId;
  private Region regionByRegionId;

  public City() {
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
  @Column(name = "postal_code")
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
  public Country getCountryByCountryId() {
    return countryByCountryId;
  }

  public void setCountryByCountryId(Country countryByCountryId) {
    this.countryByCountryId = countryByCountryId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    City that = (City) o;

    if (!Objects.equals(id, that.id)) {
      return false;
    }
    if (!Objects.equals(name, that.name)) {
      return false;
    }
    return Objects.equals(postalCode, that.postalCode);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "region_id", referencedColumnName = "id")
  public Region getRegionByRegionId() {
    return regionByRegionId;
  }

  public void setRegionByRegionId(Region regionByRegionId) {
    this.regionByRegionId = regionByRegionId;
  }
}
