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

}
