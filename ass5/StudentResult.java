import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private final Optional<T> marks;
    private final T maximumMarks;
    private final double passPercentage;

    public Result(Optional<T> marks, T maximumMarks, double passPercentage) {
        this.marks = Objects.requireNonNull(marks, "Marks cannot be null");
        this.maximumMarks = Objects.requireNonNull(
            maximumMarks, "Maximum marks cannot be null"
        );

        if (maximumMarks.doubleValue() <= 0) {
            throw new IllegalArgumentException("Maximum marks must be positive");
        }

        if (passPercentage < 0 || passPercentage > 100) {
            throw new IllegalArgumentException(
                "Pass percentage must be between 0 and 100"
            );
        }

        this.passPercentage = passPercentage;
    }

    public double calculatePercentage() {
        if (!marks.isPresent()) {
            throw new IllegalStateException("Marks are not available");
        }

        return marks.get().doubleValue()
                / maximumMarks.doubleValue() * 100.0;
    }

    public boolean hasPassed() {
        return calculatePercentage() >= passPercentage;
    }

    public void displayResult() {
        if (marks.isPresent()) {
            System.out.println("Marks: " + marks.get());
            System.out.println("Percentage: " + calculatePercentage() + "%");
            System.out.println("Result: " + (hasPassed() ? "PASS" : "FAIL"));
        } else {
            System.out.println("Marks are not available.");
        }
    }
}

public class StudentResult {
    public static void main(String[] args) {
        Result<Integer> student1 =
            new Result<>(Optional.of(85), 100, 40);

        Result<Double> student2 =
            new Result<>(Optional.of(32.5), 100.0, 40);

        Result<Integer> student3 =
            new Result<>(Optional.empty(), 100, 40);

        System.out.println("Student 1:");
        student1.displayResult();

        System.out.println("\nStudent 2:");
        student2.displayResult();

        System.out.println("\nStudent 3:");
        student3.displayResult();
    }
}