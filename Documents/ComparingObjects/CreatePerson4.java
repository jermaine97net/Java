package ComparingObjects;
import java.util.Objects;

public class CreatePerson4 extends CreatePerson{
  
    public CreatePerson4(String name, String race, int age){
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
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        CreatePerson4 otherInstance = (CreatePerson4) obj;
        return this.name.equals(otherInstance.name) && this.race.equals(otherInstance.race) && this.age == otherInstance.age;
    }
}
