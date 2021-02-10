package controllers;
import models.Todo;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import com.google.gson.*;
import play.mvc.*;

import java.util.List;

//# To stop Ebean DDL generation, remove this comment and start using Evolutions

import javax.inject.Inject;

public class TodoController extends Controller{

    @Inject
    FormFactory formFactory;

    // for all Todo

    public Result index(){
        List<Todo> todos = Todo.find.all();
        System.out.println("\n\n******\n\n");
        System.out.println(todos);
        System.out.println("\n\n******\n\n");
        JsonNode jsonNode = Json.toJson(todos);
        return ok(jsonNode).as("application/json");
        /*Gson gson = new Gson();
        String jsonTodos = gson.toJson(todos);
        return ok(jsonTodos).as("application/json");*/
    }

    // to create todo

    public Result create(Http.Request request){
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            String title = json.findPath("title").textValue();
            boolean completed = json.findPath("completed").booleanValue();
            if (title == null) {
                return badRequest("Missing parameter [title]");
            } else {
                Todo todo = new Todo();
                todo.title = title;
                todo.completed = completed;
                todo.save();
                return ok("Saved:  " + title);
            }
        }
    }

    // to save todo

    /*public Result save(){
        Form<Todo> todoForm = formFactory.form(Todo.class).bindFromRequest();
        if(todoForm.hasErrors()){
            flash("danger","Please Correct the Form Below");
            return badRequest(create.render(todoForm));
        }
        Todo todo = todoForm.get();
        todo.save();
        flash("success","Todo Save Successfully");
        return redirect(routes.TodoController.index());
    }

    public Result edit(Integer id){

        Todo todo = Todo.find.byId(id);
        if(todo==null){
            return notFound(_404.render());
        }
        Form<Todo> todoForm = formFactory.form(Todo.class).fill(todo);
        return ok(edit.render(todoForm));
    }

    public Result update(){

        Form<Todo> todoForm = formFactory.form(Todo.class).bindFromRequest();

        if (todoForm.hasErrors()){
            flash("danger","Please Correct the Form Below");
            return badRequest();
        }

        Todo todo = todoForm.get();
        Todo oldTodo = Todo.find.byId(todo.id);
        if(oldTodo ==null){
            flash("danger","Todo Not Found");
            return notFound();
        }
        oldTodo.title = todo.title;
        oldTodo.author = todo.author;
        oldTodo.price = todo.price;
        oldTodo.update();
        flash("success","Todo Updated Successfully");
        return ok();
    }

    public Result show(Integer id){
        Todo todo = Todo.find.byId(id);
        if(todo==null){
            return notFound(_404.render());
        }
        return ok(show.render(todo));
    }

    public Result destroy(Integer id){

        Todo todo = Todo.find.byId(id);
        if(todo == null){
            flash("danger","Todo Not Found");
            return notFound();
        }
        todo.delete();
        flash("success","Todo Deleted Successfully");

        return ok();
    }*/

}
