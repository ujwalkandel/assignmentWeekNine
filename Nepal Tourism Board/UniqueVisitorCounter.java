import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData)
            throws DataProcessingException {

        if (rawData.isEmpty()) {
            throw new EmptyDataException(
                    "No raw data to process! Did all tourists go missing?");
        }

        Set<String> uniqueNames = new HashSet<>();

        for (String entry : rawData) {
            String name = entry.split(":")[1].split(",")[0].trim();
            uniqueNames.add(name);
        }

        return List.of("Unique Visitors: " + uniqueNames.size());
    }

    public static void main(String[] args) {

        UniqueVisitorCounter processor = new UniqueVisitorCounter();

        try {
            System.out.println(processor.process(List.of()));
        } catch (DataProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            List<String> sample = List.of(
                    "Visitor: Donald Trump, USA",
                    "Visitor: Narendra Modi, INDIA",
                    "Guest: Ram Thapa, NEPAL"
            );

            System.out.println(processor.process(sample));

        } catch (DataProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}