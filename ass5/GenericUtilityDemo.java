import java.util.Objects;
import java.util.Optional;

class Utility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        Objects.requireNonNull(value, "Optional cannot be null");
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        Objects.requireNonNull(a, "First value cannot be null");
        Objects.requireNonNull(b, "Second value cannot be null");

        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class GenericUtilityDemo {

    public static void main(String[] args) {
        System.out.println("Are strings equal: " +
            Utility.isEqual("Java", "Java"));

        System.out.println("Are integers equal: " +
            Utility.isEqual(10, 20));

        System.out.println("Default value: " +
            Utility.getDefault(Optional.empty(), "Default Text"));

        System.out.println("Maximum integer: " +
            Utility.max(10, 25));

        System.out.println("Maximum string: " +
            Utility.max("Apple", "Banana"));

        System.out.println("Is null: " +
            Utility.isNull(null));

        System.out.println("Is null: " +
            Utility.isNull("Hello"));
    }
}