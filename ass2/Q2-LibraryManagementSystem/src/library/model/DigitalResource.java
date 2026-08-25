package library.model;

public class DigitalResource extends LibraryResource implements Printable {

    private static final double FINE_PER_DAY = 2.0;
    private String fileFormat;

    public DigitalResource(int resourceId, String title, String author, String fileFormat) {
        super(resourceId, title, author);
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * FINE_PER_DAY;
    }

    @Override
    public void printDetails() {
        System.out.println(getBasicDetails() + ", Format: " + fileFormat + ", Type: Digital Resource");
    }
}
