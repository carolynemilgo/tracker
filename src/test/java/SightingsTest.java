import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class SightingsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void sightingCorrectlyInstantiates() {
      Sightings testSightings = new Sightings( 1 , "near river","Ali");
      assertEquals(true, testSightings instanceof Sightings);
    }
    @Test
    public void sightingSavesCorrectlytotheDB_true(){
      Sightings newSighting=new Sightings(1,"near hills","Jeff");
      newSighting.save();
      assertTrue(Sightings.all().get(0).equals(newSighting));
    }
    @Test
    public void returnsAllAnimalsSighted_true(){
      Sightings firstSighting=new Sightings(1, "south", "ken");
      firstSighting.save();
      Sightings secondSighting=new Sightings(2, "east", "jill");
      secondSighting.save();
      assertTrue(Sightings.all().get(0).equals(firstSighting));
      assertTrue(Sightings.all().get(1).equals(secondSighting));
    }
    @Test
    public void returnsSIghtingsCorrespondingToId_true(){
      Sightings firstSighting=new Sightings(1, "south", "ken");
      firstSighting.save();
      Sightings secondSighting=new Sightings(2, "east", "jill");
      secondSighting.save();
      assertEquals(Sightings.find(firstSighting.getAnimalId()),firstSighting);
    }


}
