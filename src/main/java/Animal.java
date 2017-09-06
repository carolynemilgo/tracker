import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Animal{
public String name;
public int id;
public String type;
public String age;
public String health;
//declaring constants
//public static final String age;
//{"newborn", "young", "adult"};
//public static final String health;
//{"healthy", "ill", "ok"};

@Override
public boolean equals(Object otherAnimal){
  if(!(otherAnimal instanceof Animal)){
    return false;
  }else{
    Animal anotherAnimal=(Animal) otherAnimal;
    return this.getName().equals(anotherAnimal.getName())&&
           this.getAge().equals(anotherAnimal.getAge())&&
           this.getHealth().equals(anotherAnimal.getHealth());
  }
}

public String getName(){
  return name;
}

public int getId(){
  return id;
}

public String getHealth(){
  return health;
}

public String getAge(){
  return age;
}

public void delete() {
   try(Connection con = DB.sql2o.open()) {
   String sql = "DELETE FROM animals WHERE id = :id;";
   con.createQuery(sql)
     .addParameter("id", this.id)
     .executeUpdate();
   }
 }

 // public List<Sighting> getSightings(){
 //         try(Connection con = DB.sql2o.open()) {
 //           String sql = "SELECT * FROM sightings where animalid=:id";
 //           return con.createQuery(sql)
 //             .addParameter("id", this.id)
 //             .executeAndFetch(Sighting.class);
 //         }
 //       }
}
