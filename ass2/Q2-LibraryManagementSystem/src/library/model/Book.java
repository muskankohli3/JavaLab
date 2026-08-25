package library.model;

public class Book extends LibraryResource implements Printable {

    private static final double FINE_PER_DAY = 5.0;
    private String genre;

    public Book(int resourceId, String title, String author, String genre) {
        super(resourceId, title, author);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * FINE_PER_DAY;
    }

    @Override
    public void printDetails() {
        System.out.println(getBasicDetails() + ", Genre: " + genre + ", Type: Book");
    }
}
