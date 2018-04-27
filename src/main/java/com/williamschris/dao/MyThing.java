package com.williamschris.dao;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@NodeEntity
public class MyThing implements Serializable {
    @Id @GeneratedValue
    private Long neoId;

    public String id;

    @Relationship(type = "CONNECTED", direction = Relationship.UNDIRECTED)
    private Set<MyThing> associatedThings;

    public MyThing() {

    }

    public MyThing(Set<MyThing> associatedThings) {
        this.id = UUID.randomUUID().toString();
        this.associatedThings = associatedThings;
    }

    public Long getNeoId() {
        return this.neoId;
    }

    public String getId() {
        return id;
    }

    public Set<MyThing> getAssociatedThings() {
        return associatedThings;
    }
}
