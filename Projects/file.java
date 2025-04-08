import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

public class file {
  
  static List<String> names  = Arrays.asList("Kyle", "Susan", "Mathew");

  static int[] ages = {20, 19, 28};

  static Map<String, Integer> names_ages  = new HashMap<>();

  public static void main (String[] args) {
    for (int n = 0; n < names.size(); n++) {
      names_ages.put(names.get(n), ages[n]);
    }

    for (Map.Entry<String, Integer> entry: names_ages.entrySet()) {
      System.out.println("The value for Key " + entry.getKey() + " is " + entry.getValue());
    }
}

}
