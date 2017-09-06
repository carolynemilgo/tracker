import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;


public class NormalAnimal extends Animal implements DatabaseManagement{
public static final String DATABASE_TYPE="normal";

public NormalAnimal(String name){
  this.name=name;
  type=DATABASE_TYPE;
}

@Override
public boolean equals(Object otherAnimal){
  if(!(otherAnimal instanceof NormalAnimal)){
    return false;
  }else{
    NormalAnimal newNormalAnimal = (NormalAnimal) otherAnimal;
        return this.getName().equals(newNormalAnimal.getName());
  }
}

@Override
public void save(){
  try(Connection con=DB.sql2o.open()){
    String sql="INSERT INTO animals (name,type) VALUES (:name,:type)";
    this.id=(int) con.createQuery(sql, true)
    .addParameter("name", this.name)
    .addParameter("type", this.type)
    .executeUpdate()
    .getKey();
}
}
public static NormalAnimal find(int id) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM animals where id=:id";
        NormalAnimal normalAnimal = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetchFirst(NormalAnimal.class);
        return normalAnimal;
      }
    }

public static List<NormalAnimal> all(){
  String sql="SELECT * FROM animals WHERE type='normal';";
  try(Connection con=DB.sql2o.open()){
    return con.createQuery(sql)
    .executeAndFetch(NormalAnimal.class);
  }
}




}
