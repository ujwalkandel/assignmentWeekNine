public class CommutePlanner {

    public static void planMyCommute(String origin,
                                     String destination,
                                     RouteValidator validator,
                                     NavigationService navigator) {

        System.out.println("Planning your commute from "
                + origin + " to " + destination + "...");

        try {

            navigator.navigate(origin, destination, validator);

        } catch (NavigationFailedException e) {

            if (e.getCause() != null) {

                System.out.println(
                        "Cannot plan: Invalid route details.");

                System.out.println(
                        "Reason: " + e.getCause().getMessage());

            } else {

                System.out.println(
                        "Cannot plan: GPS issue.");

                System.out.println(e.getMessage());
            }

        } finally {

            System.out.println("Commute planning for "
                    + origin + " to "
                    + destination
                    + " completed.");
        }

    }

    public static void main(String[] args) {

        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService navigator = new GPSNavigationModule();

        // Valid route
        planMyCommute(
                "Thamel",
                "Patan",
                validator,
                navigator);

        // Same location
        planMyCommute(
                "Baneshwor",
                "Baneshwor",
                validator,
                navigator);

        // GPS failure
        planMyCommute(
                "Kalanki",
                "Balaju",
                validator,
                navigator);
    }
}