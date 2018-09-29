package com.teachplus.Entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(length=30)
    private String name;

    @OneToMany(mappedBy = "groupOwner")
    private Collection<GroupMembers> groupOwner;

    @OneToMany(mappedBy = "groupMember")
    private Collection<GroupMembers> groupMember;

    public Group() {}

    public Group(long id, String name, Collection<GroupMembers> groupOwner, Collection<GroupMembers> groupMember) {
        this.id = id;
        this.name = name;
        this.groupOwner = groupOwner;
        this.groupMember = groupMember;
    }
}
