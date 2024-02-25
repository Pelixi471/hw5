import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Event event1 = new Event(LocalDate.of(2023, 4, 9), "Пара", "Математический анализ в 10:20");
        Event event2 = new Event(LocalDate.of(2023, 4, 10), "Лекция", "ООП в 12:00");
        Event event3 = new Event(LocalDate.of(2023, 4, 15), "Пара", "Дискретная математика в 15:00");
        Event event4 = new Event(LocalDate.of(2023, 4, 16), "Экзамен", "Экзамен по Java в 19:30");
        Event event5 = new Event(LocalDate.of(2023, 4, 16), "Пара", "История России в 12:00");
        Event event6 = new Event(LocalDate.of(2023, 5, 1), "Лекция", "ООП в 15:00");
        Event event7 = new Event(LocalDate.of(2023, 5, 18), "Встреча", "Встреча с друзьями в 20:00");
        Event event8 = new Event(LocalDate.of(2023, 4, 12), "Встреча", "Встреча с друзьями в 20:00");
        Event event9 = new Event(LocalDate.of(2023, 4, 13), "Экзамен", "Экзамен по C++ в 18:00");
        Event event10 = new Event(LocalDate.of(2023, 5, 4), "Экскурсия", "Экскурсия по Третьяковке в 10:00");
        Event event11 = new Event(LocalDate.of(2023, 2, 24), "Каток", "Пойти на каток с красивой девочкой в 19:30");
        Event event12 = new Event(LocalDate.of(2023, 2, 24), "Прогулка", "Погулять одному в 23:00 :(");
        Schedule schedule = new Schedule();
        schedule.insert(event1).insert(event2).insert(event3)
                .insert(event4).insert(event5).insert(event6)
                .insert(event7).insert(event8).insert(event9)
                .insert(event10).insert(event11).insert(event12);

            // ПОЛУЧЕНИЕ СОБЫТИЯ
//        Optional<Event> optionalEvent = schedule.get(LocalDate.of(2023, 4, 16), "Экзамен");
//        optionalEvent.ifPresent(event -> System.out.println(event.toString()));

            // ВСЕ СОБЫТИЯ
//        List<Event> allEvents = schedule.exportAll();
//        System.out.println("Все события: \n" + allEvents);

            // ПОЛУЧАЕМ СОБЫТИЯ С-ПО ДАТУ
//        List<Event> eventsInRange = schedule.exportDateRange(LocalDate.of(2023, 4, 10), LocalDate.of(2023, 4, 15));
//        System.out.println("События в отрезке: \n" + eventsInRange);

            // ПОЛУЧАЕМ СОБЫТИЕ С ОПРЕД. НАЗВАНИЕМ
//        List<Event> meetings = schedule.exportTitle("Пара");
//        System.out.println("События: \n" + meetings);

            // УДАЛЯЕМ СОБЫТИЕ
//        Optional<Event> removedEvent = schedule.remove(LocalDate.of(2023, 4, 10), "Лекция");
//        removedEvent.ifPresent(event -> System.out.println("Удалённое событие: \n" + event));

            // УДАЛЯЕМП СОБЫТИЯ В ДИАОПОЗОНЕ ДАТ
//        List<Event> removedEventsInRange = schedule.removeDateRange(LocalDate.of(2023, 4, 10), LocalDate.of(2023, 4, 15));
//        System.out.println("Removed events in range: \n" + removedEventsInRange);

            // УДАЛЯЕМ СОБЫТИЯ С ОПРЕД. НАЗВАНИЕМ
//        List<Event> removedMeetings = schedule.removeTitle("Экзамен");
//        System.out.println("Удалённые события: \n" + removedMeetings);

            // УДАЛЯЕМ ВСЁЁЁЁЁ!!!!!
//        List<Event> allRemovedEvents = schedule.removeAll();
//        System.out.println("Удалённые события: \n" + allRemovedEvents);

    }
}