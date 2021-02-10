package models;

import java.util.HashSet;
import java.util.Set;

import io.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
// import play.data.validation.*;


@Entity
public class Todo extends Model{

    @Id
    //@Constraints.Required
    public Integer id;

    @Constraints.MaxLength(255)
    @Constraints.MinLength(5)
    @Constraints.Required
    public String title;

    @Constraints.Required
    public Boolean completed;

    public static Finder<Integer,Todo> find = new Finder<>(Todo.class);
}
