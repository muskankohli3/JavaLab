import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Objects;

public class EventManagement {

    public static void main(String[] args) {
        String eventName = Objects.requireNonNull(
            "Java Workshop", "Event name cannot be null"
        );

        LocalDate eventDate = LocalDate.now().plusDays(5);
        LocalTime startTime = LocalTime.of(10, 30);
        Optional<String> venue = Optional.of("Computer Lab");

        LocalDate today = LocalDate.now();
        LocalTime endTime = startTime.plusHours(2);

        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);

        if (eventDate.isAfter(today)) {
            System.out.println("Event Status: Future");
        } else if (eventDate.isEqual(today)) {
            System.out.println("Event Status: Today");
        } else {
            System.out.println("Event Status: Past");
        }

        long daysRemaining = ChronoUnit.DAYS.between(today, eventDate);
        System.out.println("Days Remaining: " + daysRemaining);

        System.out.println("Venue: " +
            venue.orElse("Venue not specified"));
    }
}