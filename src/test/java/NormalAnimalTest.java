import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;



public class NormalAnimalTest{

  @Rule
public DatabaseRule database = new DatabaseRule();

  @Test
  public void normalAnimal_instatiatesCorrectly_true(){
    NormalAnimal normalAnimal=new NormalAnimal("Lion");
    assertEquals(true, normalAnimal instanceof NormalAnimal);
  }

  @Test
  public void saves_normalAnimalSavesToTheDB_true(){
    NormalAnimal normalAnimal=new NormalAnimal("Lion");
    normalAnimal.save();
    assertTrue(NormalAnimal.all().get(0).equals(normalAnimal));
  }

  @Test
  public void returnsAllInstancesOfNormalAnimals_true(){
    NormalAnimal normalAnimalOne=new NormalAnimal("Zebra");
    normalAnimalOne.save();
    NormalAnimal normalAnimalTwo=new NormalAnimal("Ostrich");
    normalAnimalTwo.save();
    assertEquals(true, NormalAnimal.all().get(0).equals(normalAnimalOne));
    assertEquals(true, NormalAnimal.all().get(1).equals(normalAnimalTwo));
  }

  @Test
  public void find_returnsNormalAnimalWIthSameId_secondNormalAnimal(){
    NormalAnimal normalAnimalOne=new NormalAnimal("Ostrich");
    normalAnimalOne.save();
    NormalAnimal normalAnimalTwo=new NormalAnimal("Peacock");
    normalAnimalTwo.save();
    assertEquals(NormalAnimal.find(normalAnimalTwo.getId()), normalAnimalTwo);
  }
  @Test
  public void delete_deletesNormalAnimal_true() {
    NormalAnimal testNormalAnimal = new NormalAnimal("Zebra");
    testNormalAnimal.save();
    testNormalAnimal.delete();
    assertEquals(null, NormalAnimal.find(testNormalAnimal.getId()));
  }

}
