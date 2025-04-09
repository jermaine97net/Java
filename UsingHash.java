import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class UsingHash {

    public static void main(String[] args) {
        
        // Example 1: Filter unique integers from a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        System.out.println("Unique integers: " + uniqueNumbers);


        // Example 2: Generate a list of unique random numbers
        List<Integer> randomNumbers = generateUniqueRandomNumbers(5);
        System.out.println("Random unique numbers: " + randomNumbers);


        // Example 3: Create and display a map(dictionary) of countries and their codes
        String[] countries = {"South Africa", "USA", "Canada"};
        Integer[] countryCodes = {27, 1, 7}; 
        Map<String, Integer> countryCodeMap = new HashMap<>();

        for (int n = 0; n < countries.length; n++) {
            countryCodeMap.put(countries[n], countryCodes[n]);
        }

        System.out.println("Country Codes:");
        for (Map.Entry<String, Integer> entry : countryCodeMap.entrySet()) {
            System.out.println("Country: " + entry.getKey() + ", Code: " + entry.getValue());
        }
    }

    // Method to generate a list of unique random integers
    public static List<Integer> generateUniqueRandomNumbers(int size) {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < size) {
            uniqueNumbers.add(random.nextInt(100)); // Range 0–99
        }

        return new ArrayList<>(uniqueNumbers);
    }
}
