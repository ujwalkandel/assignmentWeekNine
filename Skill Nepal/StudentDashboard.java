public class StudentDashboard {

    public void displayCourseStatus(String studentId,
                                    String courseId,
                                    EligibilityRule rule) {

        System.out.println("Checking enrollment status for "
                + studentId + " in " + courseId + "...");

        try {

            if (rule.isEligible(studentId, courseId)) {

                System.out.println("You are enrolled! Access course materials now.");

            } else {

                System.out.println("You are not eligible for this course.");
            }

        } catch (EnrollmentDeniedException e) {

            System.out.println("Enrollment denied: "
                    + e.getMessage()
                    + ". Please contact support.");

        } finally {

            System.out.println("Status check completed for "
                    + studentId + ".");
        }
    }

    public static void main(String[] args) {

        EligibilityRule rule = (studentId, courseId) -> {

            if (studentId.equals("SKILL999")) {
                throw new EnrollmentDeniedException(
                        "Student account suspended due to outstanding fees, Roshan!");
            }

            if (courseId.equals("JAVA101")
                    && !studentId.startsWith("SKILL")) {

                throw new EnrollmentDeniedException(
                        "Invalid student ID format. Please use 'SKILL' prefix, Anisha!");
            }

            if (studentId.startsWith("SKILL")
                    && courseId.equals("JAVA101")) {

                return true;
            }

            return false;
        };

        StudentDashboard dashboard = new StudentDashboard();

        dashboard.displayCourseStatus(
                "SKILL123",
                "JAVA101",
                rule);

        dashboard.displayCourseStatus(
                "SKILL999",
                "PYTHON202",
                rule);

        dashboard.displayCourseStatus(
                "STUDENT001",
                "JAVA101",
                rule);
    }
}