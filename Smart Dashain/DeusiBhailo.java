import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeusiBhailo extends FestivalActivity {

    private List<String> plannedRoutes;
    private int numberOfPerformers;

    public DeusiBhailo(double estimatedCost,
                       List<String> plannedRoutes,
                       int numberOfPerformers) {

        super("Deusi Bhailo Program", estimatedCost);
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {

        if (plannedRoutes.isEmpty()) {
            throw new NoRouteException(
                "No routes planned for Deusi Bhailo! Are we just singing in the living room?");
        }

        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException(
                "Need at least 3 performers for a proper Deusi Bhailo!");
        }

        System.out.println("Deusi Bhailo program with "
                + numberOfPerformers
                + " performers planned for "
                + plannedRoutes.size()
                + " routes!");
    }

    public static void main(String[] args) {

        List<String> routes = Arrays.asList("Route A", "Route B");

        DeusiBhailo[] events = {
                new DeusiBhailo(10000, routes, 5),
                new DeusiBhailo(10000, new ArrayList<>(), 5),
                new DeusiBhailo(10000, routes, 2)
        };

        for (DeusiBhailo d : events) {
            try {
                d.displayOverview();
                d.planActivity();
            } catch (NoRouteException e) {
                System.out.println(e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }
    }
}