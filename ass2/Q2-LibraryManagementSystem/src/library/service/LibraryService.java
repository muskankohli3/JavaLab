package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    public void displayResourceDetails(LibraryResource resource) {
        if (!InputValidator.validateResourceId(resource.getResourceId())) {
            System.out.println("Invalid Resource ID, skipping display.");
            return;
        }
        if (resource instanceof Printable) {
            ((Printable) resource).printDetails();
        }
    }

    public double calculateTotalFine(LibraryResource[] resources, int[] overdueDays) {
        double totalFine = 0.0;

        for (int i = 0; i < resources.length; i++) {
            if (!InputValidator.validateFineDays(overdueDays[i])) {
                System.out.println("Invalid overdue days for Resource ID: " + resources[i].getResourceId());
                continue;
            }

            double fine = resources[i].calculateFine(overdueDays[i]);

            if (fine > 0) {
                System.out.println("Resource ID " + resources[i].getResourceId()
                        + " -> Overdue: " + overdueDays[i] + " day(s), Fine: Rs. " + fine);
            }

            totalFine += fine;
        }

        return totalFine;
    }
}
