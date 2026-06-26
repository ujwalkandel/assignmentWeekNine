public class TikaCeremony extends FestivalActivity {

    private int expectedGuests;
    private String mainFamilyElder;

    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {

        if (expectedGuests < 5) {
            throw new InvalidGuestCountException(
                "Not enough guests for a lively Tika! Is everyone on vacation?");
        }

        if (estimatedCost > 50000) {
            throw new BudgetExceededException(
                "Tika budget too high! Is this for the whole village?");
        }

        System.out.println("Tika ceremony with " + mainFamilyElder
                + " planned successfully for "
                + expectedGuests + " guests!");
    }

    public static void main(String[] args) {

        TikaCeremony[] ceremonies = {
                new TikaCeremony(30000, 20, "Grandfather"),
                new TikaCeremony(30000, 2, "Grandmother"),
                new TikaCeremony(70000, 15, "Father")
        };

        for (TikaCeremony t : ceremonies) {
            try {
                t.displayOverview();
                t.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println(e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println(e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
        }
    }
}