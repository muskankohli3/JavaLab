import java.util.*;

public class CourseRegistrationPortal {

    static class Course {
        private final String courseCode;
        private final String courseName;
        private final int capacity;
        private final HashSet<String> enrolledStudentIds = new HashSet<>();
        private final ArrayList<String> prerequisiteCodes = new ArrayList<>();
        private final LinkedList<String> waitlist = new LinkedList<>();

        Course(String courseCode, String courseName, int capacity, List<String> prerequisites) {
            if (capacity < 1) {
                throw new IllegalArgumentException("Course capacity must be at least 1.");
            }
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.capacity = capacity;
            if (prerequisites != null) {
                this.prerequisiteCodes.addAll(prerequisites);
            }
        }

        public String getCourseCode() {
            return courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public int getCapacity() {
            return capacity;
        }

        public HashSet<String> getEnrolledStudentIds() {
            return enrolledStudentIds;
        }

        public ArrayList<String> getPrerequisiteCodes() {
            return prerequisiteCodes;
        }

        public LinkedList<String> getWaitlist() {
            return waitlist;
        }
    }

    private final HashMap<String, Course> courses = new HashMap<>();
    // Tracks the courses each student has completed, so prerequisites can be checked.
    private final HashMap<String, HashSet<String>> completedCoursesByStudent = new HashMap<>();

    public void addCourse(String courseCode, String courseName, int capacity, List<String> prerequisites) {
        if (courses.containsKey(courseCode)) {
            throw new IllegalArgumentException("Course already exists: " + courseCode);
        }
        courses.put(courseCode, new Course(courseCode, courseName, capacity, prerequisites));
        System.out.println("Added course: " + courseCode + " - " + courseName);
    }

    public Course findCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public void recordCompletedCourses(String studentId, Collection<String> completedCourseCodes) {
        HashSet<String> completed = completedCoursesByStudent.computeIfAbsent(
                studentId, key -> new HashSet<>());
        if (completedCourseCodes != null) {
            completed.addAll(completedCourseCodes);
        }
    }

    private boolean hasPrerequisites(String studentId, Course course) {
        Set<String> completed = completedCoursesByStudent.getOrDefault(
                studentId, new HashSet<>());
        return completed.containsAll(course.getPrerequisiteCodes());
    }

    public void registerStudent(String studentId, String courseCode,
                               Collection<String> completedCourseCodes) {
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Registration failed: course not found - " + courseCode);
            return;
        }

        recordCompletedCourses(studentId, completedCourseCodes);

        if (course.getEnrolledStudentIds().contains(studentId)) {
            System.out.println(studentId + " is already enrolled in " + courseCode + ".");
            return;
        }
        if (course.getWaitlist().contains(studentId)) {
            System.out.println(studentId + " is already on the waitlist for " + courseCode + ".");
            return;
        }
        if (!hasPrerequisites(studentId, course)) {
            System.out.println("Registration denied for " + studentId + ": prerequisites missing for "
                    + courseCode + " " + course.getPrerequisiteCodes());
            return;
        }

        if (course.getEnrolledStudentIds().size() < course.getCapacity()) {
            course.getEnrolledStudentIds().add(studentId);
            System.out.println(studentId + " successfully enrolled in " + courseCode + ".");
        } else {
            course.getWaitlist().addLast(studentId);
            System.out.println(courseCode + " is full. " + studentId + " added to the waitlist.");
        }
    }

    public void dropStudent(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Drop failed: course not found - " + courseCode);
            return;
        }

        if (!course.getEnrolledStudentIds().remove(studentId)) {
            if (course.getWaitlist().remove(studentId)) {
                System.out.println(studentId + " removed from the waitlist for " + courseCode + ".");
            } else {
                System.out.println(studentId + " was not enrolled in or waitlisted for " + courseCode + ".");
            }
            return;
        }

        System.out.println(studentId + " dropped " + courseCode + ".");
        promoteFromWaitlist(course);
    }

    private void promoteFromWaitlist(Course course) {
        Iterator<String> iterator = course.getWaitlist().iterator();
        while (iterator.hasNext()) {
            String studentId = iterator.next();
            if (hasPrerequisites(studentId, course)) {
                iterator.remove();
                course.getEnrolledStudentIds().add(studentId);
                System.out.println("Waitlist promotion: " + studentId + " enrolled in "
                        + course.getCourseCode() + ".");
                return; // Only one seat was opened.
            } else {
                // A student whose prerequisites are no longer satisfied is skipped.
                System.out.println("Skipped " + studentId + " during promotion: prerequisites missing.");
            }
        }
    }

    public void displayCourse(String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }
        System.out.println("\nCourse: " + course.getCourseCode() + " - " + course.getCourseName());
        System.out.println("Capacity: " + course.getCapacity());
        System.out.println("Prerequisites (ordered): " + course.getPrerequisiteCodes());
        System.out.println("Enrolled students: " + course.getEnrolledStudentIds());
        System.out.println("Waitlist (first come, first served): " + course.getWaitlist());
    }

    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();

        portal.addCourse("CS101", "Programming Fundamentals", 2, Collections.emptyList());
        portal.addCourse("CS201", "Data Structures", 1, Arrays.asList("CS101"));

        portal.registerStudent("S101", "CS101", Collections.emptySet());
        portal.registerStudent("S102", "CS101", Collections.emptySet());
        portal.registerStudent("S103", "CS101", Collections.emptySet());

        portal.registerStudent("S101", "CS201", Arrays.asList("CS101"));
        portal.registerStudent("S102", "CS201", Arrays.asList("CS101"));

        portal.displayCourse("CS101");
        portal.dropStudent("S101", "CS101");
        portal.displayCourse("CS101");
        portal.displayCourse("CS201");
    }
}
