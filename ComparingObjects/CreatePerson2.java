package ComparingObjects;
public class CreatePerson2 extends CreatePerson {

    public CreatePerson2(String name, String race, int age){
        super(name, race, age);
    }
    
    @Override
    public String toString(){
        return getClass().getSimpleName() + "[Name:" + name + "| Race:" + race + "| age:" + age + "]"; 
    }
}
