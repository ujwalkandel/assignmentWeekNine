import java.util.ArrayList;
import java.util.List;

public class HotelRegistrationsDataSource extends TouristDataSource {

    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {

        if (sourceName.contains("Hotels") && Math.random() < 0.2) {
            throw new AuthenticationFailedException(
                    "Hotel API authentication failed! Did someone forget the password again?");
        }

        List<String> data = new ArrayList<>();
        data.add("Hotel: Yak & Yeti, Guest: Ram Thapa, NP");
        data.add("Hotel: Annapurna, Guest: Alice Smith, AU");

        return data;
    }

    public static void main(String[] args) {

        HotelRegistrationsDataSource source = new HotelRegistrationsDataSource();

        try {
            System.out.println(source.fetchData());
        } catch (DataSourceAccessException e) {
            System.out.println("Error: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Cause: " + e.getCause().getMessage());
            }
        }
    }
}