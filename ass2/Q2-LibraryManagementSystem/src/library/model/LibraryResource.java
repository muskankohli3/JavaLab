package library.model;

public abstract class LibraryResource {

    private int resourceId;
    private String title;
    private String author;

    private static String libraryName = "Central University Library";
    private static int resourceCounter = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        resourceCounter++;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public static int getResourceCounter() {
        return resourceCounter;
    }

    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + resourceCounter);
    }

    protected String getBasicDetails() {
        return "Resource ID: " + resourceId + ", Title: " + title + ", Author: " + author;
    }

    public abstract double calculateFine(int overdueDays);
}
