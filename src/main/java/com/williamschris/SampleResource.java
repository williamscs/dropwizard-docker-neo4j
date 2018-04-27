package com.williamschris;


import com.williamschris.dao.MyThing;
import org.neo4j.ogm.session.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {
    protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    public SampleResource() {
    }

    @GET
    public String helloWorld() {
        return "Hello World!";
    }

    @Path("/values")
    @GET
    public Collection<MyThing> getAllStuff() {
        return session.loadAll(MyThing.class);
    }

    @Path("/values/{id}")
    @GET
    public MyThing getStuff(@PathParam("id") String id) {
        return session.load(MyThing.class, Long.valueOf(id));
    }
}
