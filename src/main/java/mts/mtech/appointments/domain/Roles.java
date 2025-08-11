package mts.mtech.appointments.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "Roles")
@Entity
public class Roles implements Serializable {
  @Id
  @GeneratedValue(
      generator = "role_sequence",
      strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String name;
  @Column
  private String description;
  @Column
  @JsonFormat(pattern = "yyyy-MM-dd : HH:mm:ss")
  private LocalDateTime dateCreated;

  public Roles() {
  }

  public Roles(Long id, String name, String description, LocalDateTime dateCreated) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.dateCreated = dateCreated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public String toString() {
    return "Roles{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", dateCreated=" + dateCreated +
            '}';
  }
}