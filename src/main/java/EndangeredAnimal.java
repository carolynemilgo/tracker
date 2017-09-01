import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;



public class EndangeredAnimal extends Animal{


public EndangeredAnimal(String name, String health, String age){
  this.name=name;
  this.health=health;
  this.age=age;
  type=DATABASE_TYPE;
}

public void save(){
  try(Connection con=DB.sql2o.open()){
    String sql="INSERT INTO animals (name,age,health,type) VALUES (:name, :age, :health, :type)";
    this.id=(int) con.createQuery(sql, true)
    .addParameter("name", this.name)
    .addParameter("age", this.age)
    .addParameter("health", this.health)
    .addParameter("type", this.type)
    .executeUpdate()
    .getKey();
  }

}

public static List<EndangeredAnimal> all(){
  String sql="SELECT * FROM animals WHERE type='endangered';";
  try(Connection con=DB.sql2o.open()){
    return con.createQuery(sql)
    .executeAndFetch(EndangeredAnimal.class);
  }
}




}
