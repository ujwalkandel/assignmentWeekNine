import java.util.ArrayList;
import java.util.List;

public class AirportArrivalsDataSource extends TouristDataSource {

    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {

        if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
            throw new ConnectionLostException(
                    "Airport data connection lost! Maybe a pigeon sat on the antenna?");
        }

        List<String> data = new ArrayList<>();
        data.add("Visitor: Elon Musk, USA");
        data.add("Visitor: Central Cee, UK");

        return data;
    }

    public static void main(String[] args) {

        AirportArrivalsDataSource source = new AirportArrivalsDataSource();

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