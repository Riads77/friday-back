package fr.uge.friday.events;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class EventManager {

  public HashMap<String, Event> events = new HashMap<>();

  private record Schedule(DateFormat start, DateFormat end) {
    public Schedule {
      requireNonNull(start);
      requireNonNull(end);
    }
  }

  private record Event(String name, List<Schedule> schedules, String location) {
  }

  public void put(String name, List<Schedule> schedules) {
    put(name, schedules, null);
  }

  public void put(String name, List<Schedule> schedules, String location) {
    requireNonNull(name);
    requireNonNull(schedules);
    schedules.forEach(Objects::requireNonNull);
    var code = name.hashCode();
    if (events.containsKey(name)) {
      throw new IllegalArgumentException("This name is already here.");
    }
    put(name, new Event(name, schedules, location));
  }

  public void put(String name, Event event) {
    requireNonNull(event);
    events.put(name, event);
  }

  public void remove(String name) {
    requireNonNull(name);
    var removed = events.remove(name);
    if (removed == null) {
      throw new NullPointerException("This event is not existing");
    }
  }

  public void change(String name, Event event) {
    requireNonNull(name);
    requireNonNull(event);
    if (!events.containsKey(name)) {
      throw new IllegalStateException("You can't change a non existing event");
    }
    put(name, event);
    if (!name.equals(event.name())) {
      remove(name);
    }
  }
}
