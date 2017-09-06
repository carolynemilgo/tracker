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


    //   @Test
    //   public void all_returnsAllSightings_true() {
    //       Sighting testSighting1 = new Sighting( 1 , "north","john");
    //       testSighting1.save();
    //       Sighting testSighting2 = new Sighting( 2 , "south","Steve");
    //       testSighting2.save();
    //       assertTrue(Sighting.all().get(0).equals(testSighting1));
    //       assertTrue(Sighting.all().get(1).equals(testSighting2));
    //     }
    //     @Test
    //     public void find_returnsSightingWithSameId_true() {
    //         Sighting testSighting1 = new Sighting( 1 , "north","john");
    //         testSighting1.save();
    //         Sighting testSighting2 = new Sighting( 2 , "south","Steve");
    //         testSighting2.save();
    //         assertEquals(Sighting.find(testSighting2.getId()),testSighting2);
    //       }


}
