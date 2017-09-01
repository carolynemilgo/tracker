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



}
