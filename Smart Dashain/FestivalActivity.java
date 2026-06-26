public abstract class FestivalActivity {

    protected String activityName;
    protected double estimatedCost;

    public FestivalActivity(String activityName, double estimatedCost) {
        this.activityName = activityName;
        this.estimatedCost = estimatedCost;
    }

    public abstract void planActivity() throws FestivalPlanningException;

    public void displayOverview() {
        System.out.println("Activity: " + activityName);
        System.out.println("Estimated Cost: Rs. " + estimatedCost);
    }
}