import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Schedule {
    private final Map<LocalDate, Map<String, Event>> events;

    public Schedule() {
        events = new HashMap<>();
    }

    public Schedule(Collection<Event> events) {
        this();
        events.forEach(this::insert);
    }

    public Schedule insert(Event e) {
        events.computeIfAbsent(e.date(), k -> new HashMap<>()).put(e.title(), e);
        return this;
    }

    public Optional<Event> get(LocalDate date, String title) {
        Map<String, Event> dailyEvents = events.get(date);
        return dailyEvents != null ? Optional.ofNullable(dailyEvents.get(title)) : Optional.empty();
    }

    public List<Event> exportAll() {
        return events.values().stream()
                .flatMap(m -> m.values().stream())
                .sorted((e1, e2) -> e1.date().compareTo(e2.date()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Event> exportDateRange(LocalDate fromIncluding, LocalDate toIncluding) {
        return events.entrySet().stream()
                .filter(entry -> !entry.getKey().isBefore(fromIncluding) && !entry.getKey().isAfter(toIncluding))
                .flatMap(entry -> entry.getValue().values().stream())
                .sorted((e1, e2) -> e1.date().compareTo(e2.date()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Event> exportTitle(String title) {
        return events.values().stream()
                .map(day -> day.get(title))
                .filter(java.util.Objects::nonNull)
                .sorted((e1, e2) -> e1.date().compareTo(e2.date()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<Event> remove(LocalDate date, String title) {
        Map<String, Event> dailyEvents = events.get(date);
        if (dailyEvents != null) {
            return Optional.ofNullable(dailyEvents.remove(title));
        }
        return Optional.empty();
    }

    public List<Event> removeDateRange(LocalDate fromIncluding, LocalDate toIncluding) {
        List<Event> removedEvents = new ArrayList<>();
        for (LocalDate date = fromIncluding; !date.isAfter(toIncluding); date = date.plusDays(1)) {
            Map<String, Event> dailyEvents = events.get(date);
            if (dailyEvents != null) {
                removedEvents.addAll(dailyEvents.values());
                dailyEvents.clear();
            }
        }
        return removedEvents.stream()
                .sorted((e1, e2) -> e1.date().compareTo(e2.date()))
                .collect(Collectors.toList());
    }

    public List<Event> removeTitle(String title) {
        List<Event> removedEvents = new ArrayList<>();
        for (Map<String, Event> dailyEvents : events.values()) {
            Event event = dailyEvents.remove(title);
            if (event != null) {
                removedEvents.add(event);
            }
        }
        return removedEvents.stream()
                .sorted((e1, e2) -> e1.date().compareTo(e2.date()))
                .collect(Collectors.toList());
    }

    public List<Event> removeAll() {
        List<Event> allEvents = exportAll();
        events.clear();
        return allEvents;
    }
}