package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.LibraryService;

public class MainApp {

    public static void main(String[] args) {

        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book(1, "Effective Java", "Joshua Bloch", "Programming");
        resources[1] = new Book(2, "Clean Code", "Robert C. Martin", "Programming");
        resources[2] = new DigitalResource(3, "Data Structures E-Book", "M. A. Weiss", "PDF");
        resources[3] = new DigitalResource(4, "Introduction to AI - Research Paper", "Andrew Ng", "PDF");
        resources[4] = new Book(5, "Database System Concepts", "Silberschatz", "Reference");

        int[] overdueDays = {5, 0, 3, 10, 2};

        LibraryService libraryService = new LibraryService();

        System.out.println("Library: " + LibraryResource.getLibraryName());
        System.out.println("=================================================");

        for (LibraryResource resource : resources) {
            libraryService.displayResourceDetails(resource);
        }

        System.out.println("=================================================");
        double totalFine = libraryService.calculateTotalFine(resources, overdueDays);
        System.out.println("Total Fine Collected: Rs. " + totalFine);

        System.out.println("=================================================");
        LibraryResource.displayTotalResources();
    }
}
