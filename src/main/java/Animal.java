import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
 }}
