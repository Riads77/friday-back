package fr.uge.friday.events;

import java.text.DateFormat;

import static java.util.Objects.requireNonNull;

public record Schedule(DateFormat start, DateFormat end) {
  public Schedule {
    requireNonNull(start);
    requireNonNull(end);
  }
}
