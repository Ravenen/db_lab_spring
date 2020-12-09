package ua.lviv.iot.terminal.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post", schema = "pavliyk_3")
public class Post {
  private Integer id;
  private String post;

  public Post() {
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
  @Column(name = "post")
  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Post that = (Post) o;

    if (!id.equals(that.id)) {
      return false;
    }
    return post.equals(that.post);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + post.hashCode();
    return result;
  }
}
