package ua.lviv.iot.terminal.domain;

import java.sql.Date;
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
@Table(name = "terminal", schema = "pavliyk_3")
public class Terminal {
  private Integer id;
  private String gpsCoordinates;
  private Date commissioningDate;
  private Manufacturer manufacturerByManufacturerId;
  private Address addressByAddressId;

  public Terminal() {
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
  @Column(name = "gps_coordinates")
  public String getGpsCoordinates() {
    return gpsCoordinates;
  }

  public void setGpsCoordinates(String gpsCoordinates) {
    this.gpsCoordinates = gpsCoordinates;
  }

  @Basic
  @Column(name = "commissioning_date")
  public Date getCommissioningDate() {
    return (Date) commissioningDate.clone();
  }

  public void setCommissioningDate(Date commissioningDate) {
    this.commissioningDate = (Date) commissioningDate.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Terminal that = (Terminal) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!gpsCoordinates.equals(that.gpsCoordinates)) {
      return false;
    }
    if (!commissioningDate.equals(that.commissioningDate)) {
      return false;
    }
    if (!manufacturerByManufacturerId.equals(that.manufacturerByManufacturerId)) {
      return false;
    }
    return addressByAddressId.equals(that.addressByAddressId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + gpsCoordinates.hashCode();
    result = 31 * result + commissioningDate.hashCode();
    result = 31 * result + manufacturerByManufacturerId.hashCode();
    result = 31 * result + addressByAddressId.hashCode();
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "manufacturer_id", referencedColumnName = "id", nullable = false)
  public Manufacturer getManufacturerByManufacturerId() {
    return manufacturerByManufacturerId;
  }

  public void setManufacturerByManufacturerId(Manufacturer manufacturerByManufacturerId) {
    this.manufacturerByManufacturerId = manufacturerByManufacturerId;
  }

  @ManyToOne
  @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
  public Address getAddressByAddressId() {
    return addressByAddressId;
  }

  public void setAddressByAddressId(Address addressByAddressId) {
    this.addressByAddressId = addressByAddressId;
  }
}
