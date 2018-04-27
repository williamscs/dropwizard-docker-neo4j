package com.williamschris.dao;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Set;

@NodeEntity
public class MyThing implements Serializable {
    @Id @GeneratedValue
    private Long neoId;

    String id;

    @Relationship(type = "CONNECTED")
    Set<MyThing> associatedThings;

    public MyThing() {

    }

    public String getId() {
        return id;
    }

    public Set<MyThing> getAssociatedThings() {
        return associatedThings;
    }
}
