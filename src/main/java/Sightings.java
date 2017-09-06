import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.sql.Timestamp;



public class Sightings{
private int animalId;
private String location;
private String rangerName;
private int id;
private Timestamp seen;

public Sightings(int animalId,String rangerName,String location){
  this.animalId=animalId;
  this.rangerName=rangerName;
  this.location=location;
}

public int getAnimalId(){
  return id;
}
public String getLocation(){
  return location;
}

public String getRangerName(){
  return rangerName;
}

public Timestamp whenSeen(){
  return seen;
}

@Override
public boolean equals(Object otherSighting){
  if(!(otherSighting instanceof Sightings)){
    return false;
  }else{
    Sightings anotherSighting=(Sightings) otherSighting;
    return this.getLocation().equals(anotherSighting.getLocation()) &&
           this.getRangerName().equals(anotherSighting.getRangerName())&&
           this.getAnimalId() == anotherSighting.getAnimalId();
  }
}
  public void save(){
    try(Connection con=DB.sql2o.open()){
      String sql="INSERT INTO sightings (location,rangername,animalid,seen) VALUES (:location,:rangername,:animalid,now())";
      this.id= (int) con.createQuery(sql,true)
      .addParameter("location",this.location)
      .addParameter("rangername",this.rangerName)
      .addParameter("animalid", this.animalId)
      .executeUpdate()
      .getKey();
    }
  }

  public static Sightings find(int id){
    try(Connection con = DB.sql2o.open()) {
         String sql = "SELECT * FROM sightings where id=:id";
         Sightings sightings = con.createQuery(sql)
           .addParameter("id", id)
           .executeAndFetchFirst(Sightings.class);
         return sightings;
  }
}
  public static List<Sightings> all() {
     String sql = "SELECT * FROM sightings;";
     try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql)
       .executeAndFetch(Sightings.class);
     }
 }


}
