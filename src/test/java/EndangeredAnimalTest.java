import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;



public class EndangeredAnimalTest{
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endageredAnimal_instatiatesCorrectly_true(){
    EndangeredAnimal endangeredAnimal=new EndangeredAnimal("Rhino", "healthy", "young");
    assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

@Test
public void returnsAllInstancesOfEndangeredANimals_true(){
  EndangeredAnimal testEndangered=new EndangeredAnimal("White Rhino", "healthy", "old");
  testEndangered.save();
  EndangeredAnimal testEndangeredTwo=new EndangeredAnimal("Kiwi", "healthy", "old");
  testEndangeredTwo.save();
  assertEquals(true, EndangeredAnimal.all().get(0).equals(testEndangered));
  assertEquals(true, EndangeredAnimal.all().get(1).equals(testEndangeredTwo));
}

@Test
public void find_returnsEndangeredAnimalWIthSameId_secondEndangeredAnimal(){
  EndangeredAnimal endangeredAnimal=new EndangeredAnimal("Ostrich", "healthy", "old");
  endangeredAnimal.save();
  EndangeredAnimal endangeredAnimalTwo=new EndangeredAnimal("Ostrich", "healthy", "old");
  endangeredAnimalTwo.save();
  assertEquals(EndangeredAnimal.find(endangeredAnimalTwo.getId()), endangeredAnimalTwo);
}

@Test
public void delete_deletesEndangeredAnimal_true() {
  EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Zebra", "healthy", "young");
  testEndangeredAnimal.save();
  testEndangeredAnimal.delete();
  assertEquals(null, EndangeredAnimal.find(testEndangeredAnimal.getId()));
}


}
