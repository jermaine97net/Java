
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class CreateSim2 {

    private static final String[] VALID_SEX = {"male", "female"};
    private static final String[] VALID_RACES = {"black", "white", "hispanic", "indian"};

    private String name;
    private String race;
    private String sex;
    private String gender;
    private int age;
    private float mass;

    public CreateSim2(String name, String race, int age, String sex, String gender, Number mass) {
        validateInputs(name, race, age, sex, mass);

        this.name = name;
        this.race = race;
        this.age = age;
        this.sex = sex;
        this.gender = (gender != null) ? validateGender(gender) : sex;
        this.gender = (gender == null) ? sex: validateGender(gender);
        this.mass = mass.floatValue();
    }

    public CreateSim2(String name, String race, int age, String sex, Number mass) {
        this(name, race, age, sex, null, mass);
    }

    private void validateInputs(String name, String race, int age, String sex, Number mass) {
        if (!(name instanceof String)) {
            throw new IllegalArgumentException("Invalid entry 'name': " + name);
        }
        if (!(race instanceof String) || !Arrays.asList(VALID_RACES).contains(race)) {
            throw new IllegalArgumentException("Invalid entry 'race': " + race);
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid entry 'age': " + age);
        }
        if (!(sex instanceof String) || !Arrays.asList(VALID_SEX).contains(sex)) {
            throw new IllegalArgumentException("Invalid entry 'sex': " + sex);
        }
        if (!(mass instanceof Number) || mass.floatValue() <= 0) {
            throw new IllegalArgumentException("Invalid entry 'mass': " + mass);
        }
    }

    private String validateGender(String gender) {
        if (!(gender instanceof String)) {
            throw new IllegalArgumentException("Invalid entry 'gender': " + gender);
        }
        return gender;
    }

    public String getGender() {
        return gender;
    }

    public static void main(String[] args) {
        CreateSim2 sim1 = new CreateSim2("jimmy", "black", 23, "male", 60);
        System.out.println(sim1.getGender());
    }
}