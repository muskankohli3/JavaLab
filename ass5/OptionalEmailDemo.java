import java.util.Optional;

public class OptionalEmailDemo {

    public static void main(String[] args) {
        Optional<String> email = Optional.of("student@example.com");
        Optional<String> emptyEmail = Optional.empty();

        System.out.println("Email address:");
        email.ifPresent(System.out::println);

        String defaultEmail = emptyEmail.orElse("default@example.com");
        System.out.println("Email with default: " + defaultEmail);

        try {
            String requiredEmail = emptyEmail.orElseThrow(
                () -> new IllegalStateException("Email address is missing")
            );
            System.out.println("Required email: " + requiredEmail);
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}