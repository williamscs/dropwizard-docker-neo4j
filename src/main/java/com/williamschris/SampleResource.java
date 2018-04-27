package com.williamschris;


import com.williamschris.dao.MyThing;
import org.neo4j.ogm.session.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {
    private Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    public SampleResource() {
        session.deleteAll(MyThing.class);
        MyThing thing1 = new MyThing();
        thing1.id = UUID.randomUUID().toString();
        session.save(thing1);
        MyThing thing2 = new MyThing(Collections.singleton(thing1));
        session.save(thing2);
    }

    @GET
    public String helloWorld() {
        return "Hello World!";
    }

    @Path("/values")
    @GET
    public Collection<MyThing> getAllStuff() {
        return session.loadAll(MyThing.class, 0);
    }

    @Path("/values/{id}")
    @GET
    public MyThing getStuff(@PathParam("id") String id) {
        return session.load(MyThing.class, Long.valueOf(id));
    }
}
