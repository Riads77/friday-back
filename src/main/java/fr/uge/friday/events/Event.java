package fr.uge.friday.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;
  //private List<Schedule> schedules;
  private String location;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Event() {

  }

  @Override
  public String toString() {
    return "Event{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", location='" + location + '\'' +
            '}';
  }
}
