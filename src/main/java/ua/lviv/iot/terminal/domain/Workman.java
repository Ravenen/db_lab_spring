package ua.lviv.iot.terminal.domain;

import java.math.BigDecimal;
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
@Table(name = "workman", schema = "pavliyk_3")
public class Workman {
  private Integer id;
  private String name;
  private String surname;
  private BigDecimal pricePerHourUah;
  private String contactNumber;
  private Sex sexBySexId;
  private Post postByPostId;

  public Workman() {
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
  @Column(name = "surname")
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Basic
  @Column(name = "price_per_hour_uah")
  public BigDecimal getPricePerHourUah() {
    return pricePerHourUah;
  }

  public void setPricePerHourUah(BigDecimal pricePerHourUah) {
    this.pricePerHourUah = pricePerHourUah;
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

    Workman that = (Workman) o;

    if (!id.equals(that.id)) {
      return false;
    }
    if (!name.equals(that.name)) {
      return false;
    }
    if (!surname.equals(that.surname)) {
      return false;
    }
    if (!pricePerHourUah.equals(that.pricePerHourUah)) {
      return false;
    }
    if (!Objects.equals(contactNumber, that.contactNumber)) {
      return false;
    }
    if (!Objects.equals(sexBySexId, that.sexBySexId)) {
      return false;
    }
    return postByPostId.equals(that.postByPostId);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + surname.hashCode();
    result = 31 * result + pricePerHourUah.hashCode();
    result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
    result = 31 * result + (sexBySexId != null ? sexBySexId.hashCode() : 0);
    result = 31 * result + postByPostId.hashCode();
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "sex_id", referencedColumnName = "id")
  public Sex getSexBySexId() {
    return sexBySexId;
  }

  public void setSexBySexId(Sex sexBySexId) {
    this.sexBySexId = sexBySexId;
  }

  @ManyToOne
  @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
  public Post getPostByPostId() {
    return postByPostId;
  }

  public void setPostByPostId(Post postByPostId) {
    this.postByPostId = postByPostId;
  }
}
