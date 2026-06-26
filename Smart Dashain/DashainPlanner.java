import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashainPlanner {

    public static void executeFestivalPlan(List<FestivalActivity> activities) {

        for (FestivalActivity activity : activities) {

            activity.displayOverview();

            try {

                activity.planActivity();

            } catch (InvalidGuestCountException e) {

                System.out.println("Planning Warning (Guests): " + e.getMessage());

            } catch (BudgetExceededException e) {

                System.out.println("Planning Warning (Budget): " + e.getMessage());

            } catch (NoRouteException e) {

                System.out.println("Planning Warning (Routes): " + e.getMessage());

            } catch (FestivalPlanningException e) {

                System.out.println("General Planning Error: " + e.getMessage());

            } finally {

                System.out.println("Activity planning attempt for "
                        + activity.activityName
                        + " completed.");
            }
        }
    }

    public static void main(String[] args) {

        List<FestivalActivity> activities = new ArrayList<>();

        activities.add(new TikaCeremony(25000, 20, "Grandfather"));
        activities.add(new TikaCeremony(25000, 2, "Grandmother"));
        activities.add(new TikaCeremony(60000, 12, "Father"));

        activities.add(new DeusiBhailo(
                15000,
                Arrays.asList("Route A", "Route B"),
                5));

        activities.add(new DeusiBhailo(
                15000,
                new ArrayList<>(),
                5));

        activities.add(new DeusiBhailo(
                15000,
                Arrays.asList("Route C"),
                2));

        executeFestivalPlan(activities);
    }
}