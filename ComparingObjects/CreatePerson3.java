package ComparingObjects;
import java.util.Objects;

public class CreatePerson3 extends CreatePerson{
  
    public CreatePerson3(String name, String race, int age){
        super(name, race, age);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[Name:" + name + "| Race:" + race + "| age:" + age + "]";
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, race, age);
    }
    

}
