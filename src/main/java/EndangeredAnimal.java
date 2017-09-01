import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;



public class EndangeredAnimal extends Animal implements DatabaseManagement{
public static final String DATABASE_TYPE="endangered";

public EndangeredAnimal(String name, String health, String age){
  this.name=name;
  this.health=health;
  this.age=age;
  type=DATABASE_TYPE;
}

@Override
public boolean equals(Object otherAnimal){
  if(!(otherAnimal instanceof EndangeredAnimal)){
    return false;
  }else{
    EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherAnimal;
        return this.getName().equals(newEndangeredAnimal.getName());
  }
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

public static EndangeredAnimal find(int id) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM animals where id=:id";
        EndangeredAnimal endangeredAnimal = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetchFirst(EndangeredAnimal.class);
        return endangeredAnimal;
      }
    }


}
