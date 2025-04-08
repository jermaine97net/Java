import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

// @SuppressWarnings("unused")
public class file {

    public  String gender = "female";
    public static String sex = "male";

    public file (String input) {
        this.gender = input;
    }

    public String getGender () {
        return gender;
    }

    public String getSex () {
        return sex;
    }

    // public void changeGender (String newGender) {
    //     this.gender = newGender;
    // }

    public static void main (String[] args) {

        List<Object[]> nameAge = Arrays.asList(
            new Object[]{"Mathew", 35},
            new Object[]{"Susan", 57},
            new Object[]{"Peter", 27},
            new Object[]{"Tandeka",16}
        );
        
        Map<String, Integer> dictionary = new HashMap<>();

        for (Object[] item : nameAge) {
            String name = (String) item[0];
            Integer age = (Integer) item[1];
            dictionary.put(name, age);
        }

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            dictionary.put(entry.getKey(), entry.getValue() * 2);
        }

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
        }

        file pat = new file("male");
        System.out.println(pat.gender);
    }
}