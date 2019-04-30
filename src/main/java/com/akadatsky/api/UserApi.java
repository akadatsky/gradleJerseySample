package com.akadatsky.api;

import com.akadatsky.db.StudentDao;
import com.akadatsky.model.Student;
import com.akadatsky.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
public class UserApi {

    private static List<User> users = new ArrayList<>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static {
        users.add(new User("test", 11));
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        Student student = new Student("Ivan", 25);
        StudentDao studentDao = new StudentDao();
        studentDao.insert(student);
        String result = gson.toJson(student);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String result = gson.toJson(users);
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@FormParam("name") String name, @FormParam("age") int age) {
        User user = new User(name, age);
        users.add(user);
        String result = gson.toJson(user);
        return Response.status(Response.Status.OK).entity(result).build();
    }

}
